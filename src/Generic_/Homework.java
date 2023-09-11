package Generic_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Homework {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("李泽文", 200000, new MyDate(7, 21, 1998)));
        employees.add(new Employee("张泽鹏", 10000, new MyDate(10, 16, 1998)));
        employees.add(new Employee("李泽文", 8000, new MyDate(7, 22, 1998)));
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!o1.getName().equals(o2.getName()))
                    return o1.getName().compareTo(o2.getName());
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday.getYear() + "-" + birthday.getMonth() + "-" + birthday.getDay() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}

class MyDate implements Comparable<MyDate> {
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(MyDate o) {
        if (year != o.getYear())
            return year - o.getYear();
        else if (month != o.getMonth())
            return month - o.getMonth();
        else
            return day - o.getDay();
    }
}