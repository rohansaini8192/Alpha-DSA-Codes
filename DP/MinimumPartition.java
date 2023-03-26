public class MinimumPartition {
    public static int minDiff(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
        }
        int W = sum/2;
        int dp[][] = new int[n+1][W+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++) {
                int w = arr[i-1];
                if(w<=j) {
                    int inc = w + dp[i-1][j-w];
                    int exc = dp[i-1][j]; 
                    dp[i][j] = Math.max(inc,exc);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1-sum2);
    }
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        System.out.println(minDiff(arr));
    }
}
