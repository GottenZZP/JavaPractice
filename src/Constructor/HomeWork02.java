package Constructor;

public class HomeWork02 {
    public static void main(String[] args){
        
    }
}


class A01 {
    public double max(double... nums){
        double maxs = nums[0];
        for (double x : nums)
            maxs = maxs > x ? maxs : x;
        return maxs;
    }
}

class A02 {
    public int find(String str, String... strs){
        for (int i = 0; i < strs.length; i++){
            if (strs[i].equals(str))
                return i;
        }
        return -1;
    }
}

class Book {
    int value;

    public Book (int value){
        this.value = value;
    }
    public void updatePrice (int value){
        if (value > 150)
            this.value = 150;
        else if (value > 100)
            this.value = 100;
    }
}

class A03 {
    public int[] copyArr(int[] arr){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            res[i] = arr[i];
        return res;
    }
    public double[] copyArr(double[] arr){
        double[] res = new double[arr.length];
        for (int i = 0; i < arr.length; i++)
            res[i] = arr[i];
        return res;
    }
    public String[] copyArr(String[] arr){
        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
            res[i] = arr[i];
        return res;
    }
    public char[] copyArr(char[] arr){
        char[] res = new char[arr.length];
        for (int i = 0; i < arr.length; i++)
            res[i] = arr[i];
        return res;
    }
}

class Circle {
    double radius;
    
    public Circle (double radius){
        this.radius = radius;
    }

    public void showPerimeter(){
        System.out.println("半径为" + this.radius + "的圆的周长为" + 2.0 * 3.14 * this.radius);
    }
}

class Cale {
    double x1, x2;
    
    public Cale(double x1, double x2){
        this.x1 = x1;
        this.x2 = x2;
    }

    public double add(){
        return this.x1 + this.x2;
    }

    public double reduce(){
        return this.x1 - this.x2;
    }

    public double times(){
        return this.x1 * this.x2;
    }

    public double divison(){
        if (this.x2 == 0)
            System.out.println("除数不能为零！");
        else
            return this.x1 / this.x2;
        return 0.0;
    }
}

class Dog {
    String name, color;
    int age;

    public void show(){
        System.out.println("姓名：" + this.name + " 颜色：" + this.color + " 年龄：" + this.age);
    }
}