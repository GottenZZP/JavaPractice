package Poly;

public class PolyTest {
    public static void main(String[] args) {
        Master tom = new Master("Tom");
        Dog dog = new Dog("Rhubarb");
        Cat cat = new Cat("Floret");
        Fish fish = new Fish("Yellow croaker");
        Bone bone = new Bone("Large stick bone");

        tom.feed(dog, bone);
        tom.feed(cat, fish);
    }
}
