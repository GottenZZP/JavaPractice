package CPU_;

public class Syn {
    public static void main(String[] args) {
        new T2().start();
        new T2().start();
        new T2().start();
    }
}

class T2 extends Thread {
    private static int count = 100;
    private boolean loop = true;

    public synchronized void sell() {
        if (count <= 0) {
            System.out.println("票已售空");
            loop = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + " 出售1票 还剩余" + (--count) + "票");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
