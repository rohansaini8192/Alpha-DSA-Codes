public class RodCutting {
    public static int maxProfit(int rodLen, int length[], int price[]) {
        int n = length.length;
        int dp[][] = new int[n+1][rodLen+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=rodLen; j++) {
                int v = price[i-1];
                int l = length[i-1];
                if(l<=j) {
                    dp[i][j] = Math.max(v+dp[i][j-l],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rodLen];
    }
    public static void main(String[] args) {
        int rodLen = 8;
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        System.out.println(maxProfit(rodLen, length, price));
    }
}
