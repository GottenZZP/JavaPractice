package TankBattle;

import java.util.Vector;

public class Tank {
    // 坦克的坐标
    private int x;
    private int y;
    private int direct = 0;
    private int speed = 1;
    boolean isLive = true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp() {
        if (y - speed >= 0)
            y -= speed;
    }

    public void moveDown() {
        if (y + speed + 60 <= 750)
            y += speed;
    }

    public void moveLeft() {
        if (x - speed >= 0)
            x -= speed;
    }

    public void moveRight() {
        if (x + speed + 60 <= 1000)
            x += speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
