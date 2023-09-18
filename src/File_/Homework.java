package File_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Homework {
    public static void main(String[] args) {

    }
    @Test
    public void hm1() throws IOException {
        String path1 = "src/File_/myTemp";
        String path2 = "hello.txt";
        File file = new File(path1);
        if (file.exists()) {
            System.out.println(path1 + "目录已存在！");
        } else {
            if (file.mkdir()) {
                System.out.println(path1 + "目录创建成功！");
                File file1 = new File(path1, path2);
                if (file1.exists()) {
                    System.out.println(path2 + "文件已存在！");
                } else {
                    if (file1.createNewFile()) {
                        System.out.println(path2 + "文化创建成功！");
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
                        bufferedWriter.write("hello, world!");
                        bufferedWriter.close();
                        System.out.println("文件写入成功！");
                    } else {
                        System.out.println("文件创建失败！");
                    }
                }
            }
        }
    }

    @Test
    public void hm2() throws IOException {
        String path = "src/File_/new1.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(path)), StandardCharsets.UTF_8));
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        int i = 0;
        String sentence = "";
        while ((sentence = reader.readLine()) != null) {
            System.out.println(++i + " " + sentence);
        }
        reader.close();
    }
}
