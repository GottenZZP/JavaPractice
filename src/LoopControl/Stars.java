package LoopControl;

public class Stars {
    public static void main(String[] args){
        // for (int i = 1; i <= 5; i++){
        //     for (int j = 0; j < i; j++){
        //         System.out.print('*');
        //     }
        //     System.out.println();
        // }

        // for (int i = 1; i <= 11; i += 2){
        //     for (int j = 0; j < (11 - i) / 2; j++){
        //         System.out.print(' ');
        //     }
        //     for (int j = 0; j < i; j++){
        //         System.out.print('*');
        //     }
        //     System.out.println();
        // }
        
        // 打印空心三角形
        // 打印5层
        for (int i = 1; i <= 5; i++){
            // 每层前先输出总层数减去当前层数的空格字符
            for (int j = 1; j <= 5 - i; j++)
                System.out.print(' ');
            // 输出星星字符
            for (int j = 1; j <= i * 2 - 1; j++){
                // 由于是空心三角形，所以只打印最前和最后的星星
                // 并且当i到达最后一行时全部打印
                // 否则打印空格填充中心部分
                if (j == 1 || j == i * 2 - 1 || i == 5)
                    System.out.print('*');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }
}
