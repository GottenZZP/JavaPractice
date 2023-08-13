import java.util.Scanner;

public class Data03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int boy = sc.nextInt();
        int gril = sc.nextInt();
        if (boy > gril)
            System.out.println("boy");
        else
            System.out.println("gril");

        sc.close();
    }
}
