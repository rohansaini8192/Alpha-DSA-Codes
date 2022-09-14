public class GridWays {
    public static int getGridWays(int i, int j, int n, int m) {
        if(i==n-1 && j == m-1) {   // Base case (destination cell)
            return 1;
        }
        if(i==n || j==m) {         // base case (boundry crossed)
            return 0;
        }
        int w1 = getGridWays(i+1, j, n, m);   // down
        int w2 = getGridWays(i, j+1, n, m);   // right
        return w1+w2;
    }
    public static void main(String[] args) {
        int n=3, m=4;
        System.out.println(getGridWays(0, 0, n, m));
    }
}
