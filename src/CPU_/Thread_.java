package CPU_;

/**
 * https://www.bilibili.com/video/BV1fh411y7R8?t=0.5&p=582
 */
public class Thread_ {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();

        for (int i = 0; i < 60; i++) {
            System.out.println("线程：" + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵，我是小猫咪" + (++times) + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times == 80)
                break;
        }
    }
}
