package TankBattle;

import javafx.scene.control.RadioButton;

import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    private Vector<Bullet> bullets = new Vector<>();

    private int randomSpeed = 50;

    Random random = new Random();

    public int getRandomSpeed() {
        return randomSpeed;
    }

    public void setRandomSpeed(int randomSpeed) {
        this.randomSpeed = randomSpeed;
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    @Override
    public void run() {
        while (isLive) {
            if (bullets.size() < 3) {
                Bullet bullet = null;
                // Hero发射子弹
                // 接受Hero的方向，让子弹按照Hero的方向来射击
                switch (getDirect()) {
                    case 0: // 上
                        bullet = new Bullet(getX() + 20, getY(), 0);
                        break;
                    case 1: // 右
                        bullet = new Bullet(getX() + 60, getY() + 20, 1);
                        break;
                    case 2: // 下
                        bullet = new Bullet(getX() + 20, getY() + 60, 2);
                        break;
                    case 3: // 左
                        bullet = new Bullet(getX(), getY() + 20, 3);
                        break;
                }
                bullets.add(bullet);
                // 开始子弹线程
                new Thread(bullet).start();
            }

            int numMove = random.nextInt(20) + 20;
            switch (getDirect()) {
                case 0: // 向上
                    for (int i = 0; i < numMove; i++) {
                        moveUp();
                        try {
                            Thread.sleep(randomSpeed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2: // 向下
                    for (int i = 0; i < numMove; i++) {
                        moveDown();
                        try {
                            Thread.sleep(randomSpeed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3: // 向左
                    for (int i = 0; i < numMove; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(randomSpeed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1: // 向右
                    for (int i = 0; i < numMove; i++) {
                        moveRight();
                        try {
                            Thread.sleep(randomSpeed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            // 随机生成方向并移动
            setDirect(random.nextInt(4));
        }
    }
}
