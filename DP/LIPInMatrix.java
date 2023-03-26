public class LIPInMatrix {
    public static int lip(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n][m];
        dp[n-1][m-1] = 1;

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int path1=1,path2=1;
                if(i+1<n && arr[i+1][j]>arr[i][j]) {
                    path1 = dp[i+1][j] + 1;
                }
                if(j+1<m && arr[i][j+1]>arr[i][j]) {
                    path2 = dp[i][j+1] + 1;
                }
                dp[i][j] = Math.max(path1, path2);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int arr[][] = {{ 1, 2, 4, 6 },
                    { 2, 2, 3, 4 },
                    { 3, 2, 3, 4 },
                    { 4, 5, 6, 7 }};
        System.out.println(lip(arr));
    }
}