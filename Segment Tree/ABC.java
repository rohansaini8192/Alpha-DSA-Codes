public class ABC {
    public static int countWays(int n, int m, int i, int j, int dp[][]) {
        if(i==n-1 && j==m-1) {
            return 1;
        }
        if(i==n || j==m) {
            return 0;
        }
        if(dp[i][j]!=-1) {
            return dp[i][j];
        }
        return dp[i][j] = countWays(n, m, i+1, j, dp)+countWays(n, m, i, j+1, dp);
    } 
    public static void main(String[] args) {
        int n = 3, m = 4;
        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(countWays(n, m, 0, 0, dp));
    }
}