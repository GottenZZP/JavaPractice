package CPU_;

public class Homework03 {
    public static void main(String[] args) {
        Money A = new Money();
        Thread thread = new Thread(A);
        Thread thread1 = new Thread(A);

        thread.start();
        thread1.start();

    }
}

class Money implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money <= 0) {
                    System.out.println("钱取完了");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 已取走1000 剩余" + money);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}