public class LCSubstring {
    public static int lcsubstr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println("Printing dp....");
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return ans;
    }
    public static void main(String[] args) {
        String str1 = "ABCDGR";
        String str2 = "ACDGHR";
        System.out.println(lcsubstr(str1, str2));
    }
}
