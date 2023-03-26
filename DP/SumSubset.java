public class SumSubset {
    public static boolean targetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                int num = arr[i-1];
                //include
                if(num <= j && dp[i-1][j-num]) {
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        // printing dp
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n][sum];
    }
    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int sum = 10;
        System.out.println(targetSum(arr, sum));
    }
}
