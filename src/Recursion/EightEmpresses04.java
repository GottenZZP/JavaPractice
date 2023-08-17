package Recursion;

public class EightEmpresses04 {
    public static void main (String[] args) {
        // 下标表示第几行，下标对应的值表示第几列
        int[][] chessboard = new int[8][8];

        Empresses board = new Empresses();
        board.place(chessboard, 0, 0);
    }
}

class Empresses {
    public boolean place(int[][] chessboard, int i, int j) {
        // 若棋盘最后一个值不为0，则表示找到一个正确解
        if (chessboard[7][7] != 0)
            return true;
        else {
            
        }
    }
}