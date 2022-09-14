public class FibonacciSeries {
    public static int fib(int n) {
        if(n==1 || n==2) {
            return n-1;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        int n = 8;
        for(int i=1; i<=n; i++)
        {
            System.out.print(fib(i) + " ");
        }
    }
}