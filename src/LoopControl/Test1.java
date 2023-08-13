package LoopControl;

public class Test1 {
    public static void main(String[] args){
        double money = 100000d;
        int sums = 0;
        while (money > 1000){
            if (money > 50000)
                money *= 0.95;
            else
                money -= 1000;
            sums++;
        }
        System.out.println(sums);
    }
}
