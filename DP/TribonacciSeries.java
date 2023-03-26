public class TribonacciSeries {
    public static void tribonacci(int n) {
        int dp[] = new int[n];
        dp[0] = dp[1] = 0;
        dp[2] = 1;
        for(int i=3; i<n; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        System.out.println("Tribonacci series");
        for(int i=0; i<n; i++) {
            System.out.print(dp[i]+" ");
        }
    }
    public static void main(String[] args) {
        int n = 10;
        tribonacci(n);
    }
}
