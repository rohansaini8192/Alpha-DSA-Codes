public class Sudoku {
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        if(row == 9){
            return true;
        }
        int nextRow = row, nextCol = col+1;
        if(nextCol==9){            // crossed column boundry now go to second row
            nextRow = row+1;
            nextCol = 0;
        }
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for(int digit=1; digit<=9; digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit;                    // place digit
                if(sudokuSolver(sudoku, nextRow, nextCol)){  // check for remaining sudoku
                    return true;
                }
                sudoku[row][col] = 0;                       
            }
        }
        return false;
    }
    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        // check row
        for(int j=0; j<9; j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }
        //check column
        for(int i=0; i<9; i++) {
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        // check grid  (3X3)
        int sr = (row/3) * 3;           // starting row of grid
        int sc = (col/3) * 3;           // starting column of grid
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static void printSudoku(int sudoku[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku[][] = {{5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}};

        if(sudokuSolver(sudoku,0,0)){
            System.out.println("Solution exist: ");
            printSudoku(sudoku);
        }
        else{
            System.out.println("No solution");
        }
    }
}
