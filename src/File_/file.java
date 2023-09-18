package File_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class file {
    public static void main(String[] args) {

    }

    @Test
    public void fileSave1() throws IOException {
        File file = new File("/Users/gottenzzp/Documents/java_code/java_practice/src/File_/new1.txt");
        file.createNewFile();
        System.out.println("成功！");
    }

    @Test
    public void fileSave2() throws IOException {
        File file1 = new File("/Users/gottenzzp/Documents/java_code/java_practice/src/File_");
        new File(file1, "news2.txt").createNewFile();
    }
}

