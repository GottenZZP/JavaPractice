package Event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {
    private MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();

    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(500, 500);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {
    int x = 100;
    int y = 100;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    // 有字符输出时，该方法会被触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 有字符按下时，该方法会被触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyChar());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                y += 3;
                break;
            case KeyEvent.VK_UP:
                y -= 3;
                break;
            case KeyEvent.VK_LEFT:
                x -= 3;
                break;
            case KeyEvent.VK_RIGHT:
                x += 3;
                break;
        }
        this.repaint();
    }

    // 有字符释放时，该方法会被触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
