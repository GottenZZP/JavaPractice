package Map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("1", new Staff("1", "王大锤", 12800.0));
        map.put("2", new Staff("2", "王小锤", 24800.0));
        map.put("3", new Staff("3", "王中锤", 32600.0));

        // mothed 1
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Staff staff = (Staff) map.get(key);
            if (staff.getSalary() > 18000)
                System.out.println(staff);
        }

        System.out.println("====================");

        // mothed 2
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            Map.Entry m = (Map.Entry) entry;
            Staff staff = (Staff) m.getValue();
            if (staff.getSalary() > 18000)
                System.out.println(staff);
        }

    }
}

class Staff {
    private String ID;
    private String name;
    private double salary;

    public Staff(String ID, String name, double salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
