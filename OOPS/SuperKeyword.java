public class SuperKeyword {
    public static void main(String[] args) {
       Dog d = new Dog();
       d.getColor(); 
    }
}
class Animal {
    String color = "white";
}
class Dog extends Animal {
    String color = "black";
    void getColor(){
        System.out.println(color);
        System.out.println(super.color);
    }
}