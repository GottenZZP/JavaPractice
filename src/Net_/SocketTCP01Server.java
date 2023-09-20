package Net_;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        // 在本机的9999号端口监听，等待连接（必须保证9999端口没有其他程序监听）
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接···");

        // 若没有客户端连接9999端口时，程序会阻塞，等待连接
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket " + socket.getClass());

        // 通过socket.getInputStream()方法来读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();

        // 读取数据所准备的缓存空间
        byte[] bytes = new byte[1024];
        int reaLen = 0;

        // 将读取到的数据显示出来
        while ((reaLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, reaLen));
        }

        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出～");
    }
}
