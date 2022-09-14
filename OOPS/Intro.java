public class Intro {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.color = "Blue";
        p1.price = 5;
        System.out.println(p1.color);
        System.out.println(p1.price);
    }
}
class Pen {
    String color;
    int price;
}