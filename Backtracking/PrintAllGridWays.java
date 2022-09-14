public class PrintAllGridWays {
    public static void gridWays(int n, int m, int x, int y, int sol[][]){
        if(x==n-1 && y==m-1){      // Base case (last cell reached)
            sol[x][y] = 1;         // set the last cell as 1
            printWay(sol,n,m);     // now print the solution
            return;
        }
        else if(x==n || y==m)      // Base case (boundry crossed)
            return;
        //creating way
        sol[x][y] = 1;
        gridWays(n, m, x+1, y, sol);   // down
        gridWays(n, m, x, y+1, sol);   // right
        sol[x][y] = 0;              // backtracking
    }
    public static void printWay(int [][]sol,int n,int m){
        System.err.println("Way....");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=3, m=4;
        // solution matrix to print ways.
        int sol[][] = new int[n][m];
        gridWays(n, m, 0, 0,sol);
    }
}
