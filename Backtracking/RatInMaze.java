public class RatInMaze {
    public static boolean solveMaze(int maze[][], int x, int y, int sol[][]) {
        if(x==maze.length-1 && y==maze.length-1 && maze[x][y]==1){
            sol[x][y] = 1;   // make this last cell 1 and now simply return true.
            return true;
        }
        // check if current block is valid
        if(isValid(maze,x,y)){
            // check if this block is already a part of solution matrix, return false
            if(sol[x][y] == 1){
                return false;
            }
            // else make it a part of solution
            sol[x][y] = 1;
            // right
            if(solveMaze(maze, x, y+1, sol)){
                return true;
            }
            // down
            if(solveMaze(maze, x+1, y, sol)){
                return true;
            }
            // if none of above give solution then backtrack and unmark this block from solution.
            sol[x][y] = 0;
            return false;
        }
        return false;
    }
    public static boolean isValid(int maze[][], int x, int y){
        return (x>=0 && y>=0 && maze[x][y]==1);
    }
    public static void printSolution(int sol[][]){
        for(int i=0; i<sol.length; i++){
            for(int j=0; j<sol.length; j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int maze[][] = 
        {{1,0,0,0},
        {1,1,0,1},
        {0,1,0,0},
        {1,1,1,1}};
        int n = maze.length;
        // solution matrix 
        int sol[][] = new int[n][n];
        if(solveMaze(maze, 0, 0, sol)){
            System.out.println("Solution is: ");
            printSolution(sol);
        }
        else{
            System.out.println("No solution");
        }
    }
}
