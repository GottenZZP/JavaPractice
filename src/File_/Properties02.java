package File_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/File_/mysql.properties"));
        properties.list(System.out);

        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println(user + " " + pwd);
    }
    @Test // 使用Proerties来创建配置文件，修改配置内容
    public void properties03() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charset", "gbk");
        properties.setProperty("ip", "172.168.1.148");
        properties.store(new FileOutputStream("src/File_/mysql2.properties"), null);
    }
}
