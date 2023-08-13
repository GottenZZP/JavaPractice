import java.util.Scanner;

public class MaxHeight04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the first monk weight: ");
        int monk1 = sc.nextInt();
        System.out.println("Please enter the second monk weight: ");
        int monk2 = sc.nextInt();
        System.out.println("Please enter the third monk weight: ");
        int monk3 = sc.nextInt();

        int max_weight = (monk1 > monk2 ? monk1 : monk2) > monk3 ? (monk1 > monk2 ? monk1 : monk2) : monk3;
        System.out.println("Max height is " + max_weight);
        sc.close();
        
        
    }
}