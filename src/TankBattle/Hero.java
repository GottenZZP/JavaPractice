package TankBattle;

import java.util.Vector;

public class Hero extends Tank {
    private Vector<Bullet> bullets = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void shoot() {
        if (bullets.size() >= 5)
            return;
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
}
