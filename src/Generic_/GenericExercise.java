package Generic_;

import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {
        HashSet<Stu> hashSet = new HashSet<Stu>();
        hashSet.add(new Stu("小明"));
        hashSet.add(new Stu("小黄"));
        hashSet.add(new Stu("小李"));

        for (Stu stu : hashSet) {
            System.out.println(stu);
        }

        Iterator<Stu> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Stu stu = iterator.next();
            System.out.println(stu);
        }


        HashMap<String, Stu> hashMap = new HashMap<String, Stu>();
        hashMap.put("小明", new Stu("小明"));
        hashMap.put("小黄", new Stu("小黄"));
        hashMap.put("小李", new Stu("小李"));

        Set<String> keySet = hashMap.keySet();
        for (Object key : keySet) {
            Stu stu = hashMap.get(key);
            System.out.println(stu);
        }
        Set<Map.Entry<String, Stu>> entrySet = hashMap.entrySet();
        for (Object entry : entrySet) {

        }


    }
}

class Stu {
    private String name;

    public Stu(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
