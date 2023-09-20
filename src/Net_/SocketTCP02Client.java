package Net_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.211.55.4", 9999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello server!".getBytes());

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
