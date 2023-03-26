public class EditDistance {
    public static int minOpr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        // initialization
        for(int i=0; i<=n; i++) {
            dp[i][0] = i;
        }
        for(int j=0; j<=m; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int add = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add,Math.min(delete,replace));
                }
            }
        }
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "sbd";
        System.out.println(minOpr(str1, str2));
    }
}
