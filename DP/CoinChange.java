public class CoinChange {
    public static int ways(int coins[], int sum) {
        int n = coins.length;
        int dp[] = new int[sum+1];
        dp[0] = 1;

        for(int i=0; i<n; i++) {
            for(int j=1; j<=sum; j++) {
                int coin = coins[i];
                if(coin<=j) {
                    dp[j] = dp[j-coin] + dp[j];   // inc + exc
                }
                else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) {
        int coins[] = {2,3,5};
        int sum = 10;
        System.out.println(ways(coins, sum));
    }
}
