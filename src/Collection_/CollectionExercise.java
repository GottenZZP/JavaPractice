package Collection_;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Dog dog = new Dog("旺财", 4);
        Dog dog1 = new Dog("富贵", 5);
        Dog dog2 = new Dog("可乐", 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(dog);
        arrayList.add(dog1);
        arrayList.add(dog2);
//        for (Object o : arrayList) {
//            System.out.println(o);
//        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
