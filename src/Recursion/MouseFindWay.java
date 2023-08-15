package Recursion;

import java.util.Random;
import java.util.Scanner;
public class MouseFindWay {
    public static void main(String[] args){
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入迷宫的行和列: ");
        int row = sc.nextInt();
        int col = sc.nextInt();


        int[][] map = new int[row][col];

        // 迷宫初始化
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || i == map.length - 1 || j == 0 || j == map[i].length - 1 || (rand.nextInt(100) + 1) < 30)
                    map[i][j] = 1;
            }
        }
        // 迷宫入口和出口不能为墙壁
        map[1][1] = 0;
        map[row - 2][col - 2] = 0;

        // 打印迷宫
        for (int[] intRow : map) {
            for (int x : intRow)
                System.out.print(x + " ");
            System.out.println();
        }

        // 小老鼠走迷宫
        Mouse m = new Mouse();
        boolean res = m.findWay(map, 1, 1);

        // 打印迷宫
        System.out.println("----------------------------------------");
        for (int[] intRow : map) {
            for (int x : intRow)
                System.out.print(x + " ");
            System.out.println();
        }

        if (res)
            System.out.println("\n老鼠可以走出迷宫！");
        else
            System.out.println("\n老鼠不能走出迷宫！");

        sc.close();
    }
}

class Mouse {
    public boolean findWay(int[][] map, int i, int j){
        /*
            1：墙壁，2：可以走，3：走不通
            老鼠行走策略：下、右、上、左
        */
        // 若迷宫出口处为2则表示可以走出
        if (map[map.length - 2][map.length - 2] == 2)
            return true;
        else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (findWay(map, i + 1, j))
                    return true;
                else if (findWay(map, i, j + 1))
                    return true;
                else if (findWay(map, i - 1, j))
                    return true;
                else if (findWay(map, i, j - 1))
                    return true;
                else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
