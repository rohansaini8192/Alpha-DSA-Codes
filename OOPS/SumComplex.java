public class SumComplex {
    public static void main(String[] args) {
        Complex n1 = new Complex(3, 2);
        Complex n2 = new Complex(2, 5);
        Complex sum = Complex.add(n1, n2);
        sum.printComplex();
    }
}
class Complex {
    int real;
    int img;
    public Complex(int r, int i) { // Constructor
        real = r;
        img = i;
    }
    public static Complex add(Complex a, Complex b){    // a method which have return type Complex
        return new Complex((a.real+b.real), (a.img+b.img));
    }
    public void printComplex() {  
        System.out.println(real + "+" + img + "i");
    }
}
