public class Multilevel {
    public static void main(String[] args) {
        Dog rudo = new Dog();
        rudo.breed = "libra";
        System.out.println(rudo.breed);
        rudo.walk();
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
class Mammal extends Animal {
    void walk(){
        System.out.println("walks");
    }
}
class Dog extends Mammal {
    String breed;
}