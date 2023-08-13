package LoopControl;

public class Test2 {
    public static void main(String[] args){
        double res = 1;

        for (int i = 2; i <= 100; i++){
            double tmp = 1 / (double)i;
            if (i % 2 == 0)
                res -= tmp;
            else
                res += tmp;
        }

        System.out.println(res);
    }
}
