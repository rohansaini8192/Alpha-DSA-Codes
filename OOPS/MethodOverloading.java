public class MethodOverloading {
    public static void main(String[] args) {
        Calculator cl = new Calculator();
        System.out.println(cl.sum(3, 5));
        System.out.println(cl.sum(2.5f, 3.6f));
        System.out.println(cl.sum(3, 5, 3));
    }
}
class Calculator {
    int sum(int a, int b) {
        return a+b;
    }
    float sum(float a, float b) {
        return a+b;
    }
    int sum(int a, int b, int c) {
        return a+b+c;
    }
}