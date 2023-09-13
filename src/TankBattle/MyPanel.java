package TankBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    Hero hero;
    // 存放敌人坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();
    // 存放爆炸图片
    // 当子弹击中坦克时加入一个Bomb对象
    Vector<Bomb> bombs = new Vector<>();
    int enemySize = 3;

    Random random = new Random();

    Image image1;
    Image image2;
    Image image3;

    public MyPanel() {
        // 初始化自己的坦克
        hero = new Hero(480, 600);
        hero.setSpeed(10);

        // 初始化敌方坦克
        for (int i = 0; i < enemySize; i++) {
            int randomX = random.nextInt(800) + 60;
            int randomY = random.nextInt(200) + 60;
            // 创建敌方坦克对象
            EnemyTank enemyTank = new EnemyTank(randomX, randomY);
            enemyTank.setDirect(2);
            enemyTank.setSpeed(1);
            // 开启敌方坦克线程，使得每个敌方坦克可以自主随机移动
            new Thread(enemyTank).start();

            // 给敌人创建子弹对象
            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            // 将其加入该敌人的子弹vector中
            enemyTank.getBullets().add(bullet);
            // 启动该子弹对象
            new Thread(bullet).start();
            // 将坦克对象放入敌方坦克集合中
            enemyTanks.add(enemyTank);
        }

        // 初始化坦克爆炸图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.png"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 绘制背景色
        g.fillRect(0, 0, 1000, 750);
        // 绘制自己坦克
        if (hero != null && hero.isLive()) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);

            // 遍历hero的所有子弹
            for (int i = 0; i < hero.getBullets().size(); i++) {
                Bullet bullet = hero.getBullets().get(i);
                // 当前子弹不为空且存活时，绘制该子弹
                if (bullet != null && bullet.isLive()) {
                    drawBullet(bullet.getX(), bullet.getY(), g, 0);
                } else {
                    hero.getBullets().remove(bullet);
                }
            }
        }

        // 绘制爆炸效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
            // 炸弹生命在某些范围时绘制指定图片
            if (bomb.getLife() > 6)
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            else if (bomb.getLife() > 3)
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            else
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            bomb.lifeDown();

            if (bomb.getLife() == 0)
                bombs.remove(bomb);
        }

        //绘制敌方坦克和其子弹
        for (EnemyTank enemyTank : enemyTanks) {
            // 若敌方坦克存活才绘制该坦克
            if (enemyTank.isLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                // 绘制当前坦克的所有子弹
                for (int j = 0; j < enemyTank.getBullets().size(); j++) {
                    Bullet bullet = enemyTank.getBullets().get(j);
                    // 若子弹存活则绘制，否则将其移除该坦克的子弹集合中
                    if (bullet.isLive()) {
                        drawBullet(bullet.getX(), bullet.getY(), g, 1);
                    } else {
                        enemyTank.getBullets().remove(bullet);
                    }
                }
            }
        }
    }

    /**
     * 绘制坦克
     *
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克的方向（0:向上，1:向右，2:向下，3:向左）
     * @param type   坦克的类型（我方或敌方坦克）
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        // 根据不同类型的坦克，设置不同颜色
        switch (type) {
            case 0: // 我方坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 敌方坦克
                g.setColor(Color.yellow);
                break;
        }
        // 画坦克
        switch (direct) {
            case 0: // 朝向上
                // 按照坦克定位画出坦克的左轮
                g.fill3DRect(x, y, 10, 60, false);
                // 按照坦克定位画出坦克的右轮
                g.fill3DRect(x + 30, y, 10, 60, false);
                // 按照坦克定位画出坦克的身子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 按照坦克定位画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);
                // 按照坦克定位画出坦克的炮筒
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: // 朝向右
                // 按照坦克定位画出坦克的左轮
                g.fill3DRect(x, y, 60, 10, false);
                // 按照坦克定位画出坦克的右轮
                g.fill3DRect(x, y + 30, 60, 10, false);
                // 按照坦克定位画出坦克的身子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 按照坦克定位画出坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);
                // 按照坦克定位画出坦克的炮筒
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: // 朝向下
                // 按照坦克定位画出坦克的左轮
                g.fill3DRect(x, y, 10, 60, false);
                // 按照坦克定位画出坦克的右轮
                g.fill3DRect(x + 30, y, 10, 60, false);
                // 按照坦克定位画出坦克的身子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 按照坦克定位画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);
                // 按照坦克定位画出坦克的炮筒
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: // 朝向左
                // 按照坦克定位画出坦克的左轮
                g.fill3DRect(x, y, 60, 10, false);
                // 按照坦克定位画出坦克的右轮
                g.fill3DRect(x, y + 30, 60, 10, false);
                // 按照坦克定位画出坦克的身子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 按照坦克定位画出坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);
                // 按照坦克定位画出坦克的炮筒
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    public void drawBullet(int x, int y, Graphics g, int type) {
        // 根据不同类型的坦克，设置不同颜色的子弹
        switch (type) {
            case 0: // 我方坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 敌方坦克
                g.setColor(Color.yellow);
                break;
        }
        // 绘制子弹
        g.draw3DRect(x, y, 1, 1, false);
    }

    public void hitEnemyTank() {
        for (int i = 0; i < hero.getBullets().size(); i++) {
            Bullet bullet = hero.getBullets().get(i);
            // 若hero子弹还存活时才执行
            if (bullet != null && bullet.isLive()) {
                // 遍历每个坦克，判断是否被击中
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(bullet, enemyTank);
                }
            }
        }
    }

    public void hitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.getBullets().size(); j++) {
                Bullet bullet = enemyTank.getBullets().get(j);
                if (bullet != null && bullet.isLive()) {
                    hitTank(bullet, hero);
                }
            }
        }
    }

    public void hitTank(Bullet bullet, Tank enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0:
            case 2:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 40
                 && bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 60) {
                    bullet.setLive(false);
                    hero.getBullets().remove(bullet);

                    enemyTank.setLive(false);
                    enemyTanks.remove(enemyTank);
                    // 当子弹击中坦克时，创建爆炸对象，并将其放入bomb集合中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 60
                 && bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 40) {
                    bullet.setLive(false);
                    hero.getBullets().remove(bullet);

                    enemyTank.setLive(false);
                    enemyTanks.remove(enemyTank);
                    // 当子弹击中坦克时，创建爆炸对象，并将其放入bomb集合中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 监听键盘事件
     *
     * @param e 监听键盘事件对象
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // 根据监听键盘从而改变坦克的方向和移动
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: // 向上
                if (hero.getDirect() != 0)
                    hero.setDirect(0);
                hero.moveUp();
                break;
            case KeyEvent.VK_S: // 向下
                if (hero.getDirect() != 2)
                    hero.setDirect(2);
                hero.moveDown();
                break;
            case KeyEvent.VK_A: // 向左
                if (hero.getDirect() != 3)
                    hero.setDirect(3);
                hero.moveLeft();
                break;
            case KeyEvent.VK_D: // 向右
                if (hero.getDirect() != 1)
                    hero.setDirect(1);
                hero.moveRight();
                break;
            case KeyEvent.VK_J: // 坦克射击
                hero.shoot();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hitEnemyTank();
            hitHero();
            this.repaint();
        }
    }
}
