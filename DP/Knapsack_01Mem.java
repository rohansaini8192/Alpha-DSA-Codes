public class Knapsack_01Mem {
    public static int knapsack(int wt[],int val[],int W,int n, int dp[][]) {
        if(W==0 || n==0) {
            return 0;
        }
        if(dp[n][W] != 0) {
            return dp[n][W];
        }
        if(wt[n-1]<=W) {
            //include
            int ans1 = val[n-1]+knapsack(wt, val, W-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsack(wt, val, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        else {
            dp[n][W] = knapsack(wt, val, W, n-1, dp);
            return dp[n][W];
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int wt[] = {2,5,1,3,4};
        int val[] = {15,14,10,45,30};
        int W = 7;
        int dp[][] = new int[wt.length+1][W+1];
        System.out.println(knapsack(wt, val, W, n, dp));
    }
}
