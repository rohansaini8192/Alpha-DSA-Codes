public class Heirarchical {
    public static void main(String[] args) {
        Bird parrot = new Bird();
        parrot.breathe();
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
class Bird extends Animal {
    void fly(){
        System.out.println("flys");
    }
}
