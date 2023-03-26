public class CatalanNumber {     // Memoization
    public static int catalan(int n,int dp[]) {
        if(n==0 || n==1) {
            return 1;
        }
        if(dp[n]!=0) {
            return dp[n];
        }
        int ans = 0; // Cn
        for(int i=0; i<=n-1; i++) {
            ans += catalan(i,dp)*catalan(n-i-1,dp);
        }
        return dp[n] = ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n+1];
        System.out.println(catalan(n,dp));
    }
}
