public class SingleInheritance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.fins = 2;
        System.out.println(shark.fins);
        shark.eat();
    }
}
class Animal {
    void eat() {
        System.out.println("eats");
    }
    void breathe() {
        System.out.println("breathes");
    }
}
class Fish extends Animal {
    int fins;
}