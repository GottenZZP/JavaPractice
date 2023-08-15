package Array;

import java.util.Scanner;
public class YangHui {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();

        // Init array
        int[][] arr = new int[row][];
        for (int i = 0; i < row; i++)
            arr[i] = new int[i + 1];

        // Set value
        arr[0][0] = 1;
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (j - 1 < 0)
                    arr[i][j] = arr[i - 1][j];
                else if (j >= arr[i - 1].length)
                    arr[i][j] = arr[i - 1][j - 1];
                else
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) System.out.print(' ');
            for (int j = 0; j < arr[i].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
