package CPU_;

public class Homework01 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                Thread thread = new Thread(new T());
                thread.start();
                thread.join();
            }
            System.out.println("hi " + (i + 1));
            Thread.sleep(1000);
        }
    }
}

class T implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello " + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
