package Generic_;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {




    }

    @Test
    public void test1() {
        DAO<User> dao = new DAO<>(new HashMap<>());
        dao.save("1", new User(1, 18, "Jack"));
        dao.save("2", new User(2, 20, "Mary"));
        List<User> list = dao.list();
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println(dao.get("2"));

        dao.update("1", new User(1, 19, "Bank"));
        list = dao.list();
        for (User user : list) {
            System.out.println(user);
        }

        dao.delete("1");
        for (User user : dao.list()) {
            System.out.println(user);
        }
    }
}

class DAO<T> {
    private Map<String, T> map;

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public Map<String, T> getMap() {
        return map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        Collection<T> values = map.values();
        return (List<T>) new ArrayList<>(values);
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
