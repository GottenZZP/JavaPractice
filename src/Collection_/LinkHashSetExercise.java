package Collection_;

import java.util.LinkedHashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class LinkHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();
        set.add(new Car("奥拓", 1000));
        set.add(new Car("奥迪", 300000));
        set.add(new Car("奔驰", 20000000));
        set.add(new Car("奥迪", 399900));
        set.add(new Car("马自达", 50000));
        set.add(new Car("奥拓", 1000));
        set.add(new Car("马自达", 50005));
        System.out.println(set);
    }
}

class Car {
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
