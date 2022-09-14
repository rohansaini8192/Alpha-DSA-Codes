public class MethodOverriding {
    public static void main(String[] args) {
        Herbivorous cow = new Herbivorous();
        cow.eat();
    }
}
class Animal {
    void eat() { 
        System.out.println("eats");
    }
}
class Herbivorous extends Animal {
    void eat() {
        System.out.println("eats grass");
    }
}