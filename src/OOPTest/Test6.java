package OOPTest;

public class Test6 {
    public static void main(String[] args) {

    }
}

class Grand {
    String name;
    private int age;

    public void g1() {}
}

class Father extends Grand {
    String id;
    private double score;

    public void f1() {
        // super -> name(Grand), g1(Grand)
        // this -> name(Grand), id, score, f1
    }
}

class Son extends Father {
    String name;
    public void g1() {}
    private void show() {
        // super -> name, id(Father), g1(Grand), f1(Father)
        // this -> name, id(Father), g1, f1(Father)
    }
}
