package TankBattle;

import javax.swing.*;
import java.awt.*;

public class TankGame01 extends JFrame {
    private MyPanel mp = null;
    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();

    }

    public TankGame01() {
        // 创建面板
        mp = new MyPanel();
        // 在JFrame画框中添加mp面板
        this.add(mp);
        // 设置画框大小
        this.setSize(1000, 750);
        // 监听mp面板的键盘事件
        this.addKeyListener(mp);
        // 设置点击关闭窗口则退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置显示
        this.setVisible(true);
    }
}
