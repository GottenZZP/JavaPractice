package Net_;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("9999 port was start, waiting for connection```");
        Socket socket = serverSocket.accept();
        System.out.println("Connect Client success!");

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello client!".getBytes());
        // set write end flag
        socket.shutdownOutput();

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("Close connect!");
    }
}
