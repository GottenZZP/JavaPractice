package Net_;
import java.io.IOException;
import java.net.InetAddress;

public class API_ {
    public static void main(String[] args) throws IOException {
        // 直接获取本机的InetAddress对象（得到本机名称和IP地址）
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        // 输入主机名，获得该主机的IP地址
//        InetAddress address = InetAddress.getByName("zhangxiengdeMBP");
//        System.out.println(address);

        // 根据域名返回该域名所对应的IP地址
        InetAddress address1 = InetAddress.getByName("www.baidu.com");
        System.out.println(address1);

        // 通过InetAddress对象获得IP地址
        String hostAddress = address1.getHostAddress();
        System.out.println(hostAddress);
    }
}
