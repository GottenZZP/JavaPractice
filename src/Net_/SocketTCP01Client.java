package Net_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        // 1.连接服务器（IP，端口）
        // 连接本机的9999端口，若连接成功，则返回Socket对象
//        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        Socket socket = new Socket("10.211.55.4", 9999);

        System.out.println("客户端 socket返回" + socket.getClass());

        // 连接服务端后通过socket内部的getOutputStream方法得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        // 通过输出流，写入数据到数据通道
        outputStream.write("hello, server".getBytes());

        // 关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出～");
    }
}
