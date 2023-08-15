package Recursion;

public class MonkeyEatPeaches02 {
    public static void main(String[] args){
        Monkey m = new Monkey();
        long res = m.Eat(3, 1);
        System.out.println(res);
    }
}

class Monkey {
    public long Eat(int n, long s){
        if (n == 1)
            return s;
        return Eat(n - 1, (s + 1) * 2);
    }
}