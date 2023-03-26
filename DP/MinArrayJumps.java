import java.util.Arrays;

public class MinArrayJumps {
    public static int minJumps(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--) {
            int steps = arr[i];
            int jumps = Integer.MAX_VALUE;
            for(int j=i+1; j<=i+steps && j<n; j++) {
                if(dp[j] != -1) {          // path exists from jth index
                    jumps = Math.min(jumps, dp[j]+1);
                }
            }
            if(jumps!=Integer.MAX_VALUE) {
                dp[i] = jumps;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        System.out.println(minJumps(arr));
    }
}
