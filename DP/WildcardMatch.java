public class WildcardMatch {
    public static boolean isMatch(String t, String p){
        int n = t.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        // initialization
        dp[0][0] = true;
        for(int i=1; i<=n; i++) {
            dp[i][0] = false;
        }
        for(int j=1; j<=m; j++) {
            if(p.charAt(j-1)=='*') {
                dp[0][j] = dp[0][j-1];
            }
            else{
                dp[0][j] = false;
            }
        }
        //filling dp
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                // case 1,2
                if(t.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                // case 3
                else if(p.charAt(j-1)=='*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String text = "baaabab";
        String pattern = "ba*a?";
        System.out.println(isMatch(text, pattern));
    }
}
