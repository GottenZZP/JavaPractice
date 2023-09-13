package CPU_;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        a.start();
        b.start();
    }
}

class A extends Thread {
    public static boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            int randomInt = (int) (Math.random() * 100) + 1;
            System.out.println(Thread.currentThread().getName() + " " + randomInt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B extends Thread {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        char c = scanner.next().toUpperCase().charAt(0);
        if (c == 'Q')
            A.loop = false;
    }
}