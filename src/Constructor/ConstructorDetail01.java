package Constructor;


public class ConstructorDetail01 {
    public static void main(String[] args){
        Person p1 = new Person("李四", 22);
        System.out.println("p1姓名: " + p1.name + " p1年龄: " + p1.age);
    }
}

class Person {
    String name;
    int age;
    
    public Person(String pname, int page){
        name = pname;
        age = page;
    }

    public Person(String pname){
        name = pname;
        age = 18;
    }

    public Person(int page){
        age = page;
        name = "张三";
    }
}
