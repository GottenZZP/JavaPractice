import java.util.Scanner;

public class Input01{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number one:");
        int a = sc.nextInt();
        System.out.println("Please enter number two:");
        int b = sc.nextInt();
        System.out.println(a + b);
        sc.close();
    }
}