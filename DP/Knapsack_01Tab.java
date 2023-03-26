public class Knapsack_01Tab {
    public static int knapsack(int wt[],int val[],int W) {
        int n = wt.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++) {
                int w = wt[i-1]; // ith item wt.
                int v = val[i-1];  // ith item val.
                if(w <= j) {
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("Printing table: ");
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=W; j++) {
                System.err.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int wt[] = {2,5,1,3,4};
        int val[] = {15,14,10,45,30};
        int W = 7;
        System.out.println(knapsack(wt, val, W));
    }
}
