package Collection_;

import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings({"all"})
public class ArrayList_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        arrayList.add(10);
        for (int i = 11; i < 15; i++) {
            arrayList.add(i);
        }
        arrayList.add(15);

    }
}

class A {
    private String a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a1 = (A) o;
        return Objects.equals(a, a1.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
