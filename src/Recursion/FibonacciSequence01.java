package Recursion;

public class FibonacciSequence01 {
    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        long res = f.FSequence(20);
        System.out.println(res);
    }
}

class Fibonacci {
    public long FSequence(long n){
        if (n == 1 || n == 2)
            return 1;
        return FSequence(n - 1) + FSequence(n - 2);
    }
}
