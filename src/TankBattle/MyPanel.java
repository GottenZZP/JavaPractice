package TankBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    Hero hero;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemySize = 3;


    public MyPanel() {
        // 初始化自己的坦克
        hero = new Hero(100, 100);

        // 初始化敌方坦克
        for (int i = 0; i < enemySize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 2), 100);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 绘制背景色
        g.fillRect(0, 0, 1000, 750);
        // 绘制自己坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        //绘制敌方坦克
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
        }


    }

    /**
     * 绘制坦克
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 监听键盘事件
     * @param e 监听键盘事件对象
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // 根据监听键盘从而改变坦克的方向和移动
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: // 向上
                if (hero.getDirect() != 0)
                    hero.setDirect(0);
                hero.moveUp();
                break;
            case KeyEvent.VK_DOWN: // 向下
                if (hero.getDirect() != 2)
                    hero.setDirect(2);
                hero.moveDown();
                break;
            case KeyEvent.VK_LEFT: // 向左
                if (hero.getDirect() != 3)
                    hero.setDirect(3);
                hero.moveLeft();
                break;
            case KeyEvent.VK_RIGHT: // 向右
                if (hero.getDirect() != 1)
                    hero.setDirect(1);
                hero.moveRight();
                break;

        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
