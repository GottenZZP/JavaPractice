package Array;

import java.util.Scanner;

public class ArrayReduce {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5};

        while (true) {
            System.out.println("是否缩减数组？y/n");
            char re = sc.next().charAt(0);
            if (re == 'n') break;
            else {
                if (arr.length == 1) {
                    System.out.println("数组只剩下一个啦，不能继续缩小！");
                    break;
                }
            }
            int[] tmp = new int[arr.length - 1];
            System.arraycopy(arr, 0, tmp, 0, tmp.length);

            System.out.println("----------------------");
            arr = tmp;
            for (int j : arr) System.out.print(j + " ");

        }
    }
}
