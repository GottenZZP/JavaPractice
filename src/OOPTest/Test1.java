package OOPTest;

public class Test1 {
    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("张三", 35, "程序员");
        persons[1] = new Person("李四", 24, "工程师");
        persons[2] = new Person("王五", 30, "管理员");

        for (Person person : persons) {
            System.out.println(person.getName() + "\t" + person.getAge() + "\t" + person.getJob());
        }

        new Sort().sort(persons);

        System.out.println("================");
        for (Person person : persons) {
            System.out.println(person.getName() + "\t" + person.getAge() + "\t" + person.getJob());
        }
    }
}

class Sort {
    public void sort(Person[] p) {
        int n = p.length;
        while (n > 0) {
            for (int i = 0; i + 1 < n; i++) {
                if (p[i].getAge() > p[i + 1].getAge()) {
                    Person tmp = p[i + 1];
                    p[i + 1] = p[i];
                    p[i] = tmp;
                }
            }
            n--;
        }
    }
}

class Person {
    private String name, job;
    private int age;

    public Person(String name, int age, String job) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
