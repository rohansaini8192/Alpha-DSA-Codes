// Search in sorted array
public class stairSearch {
    public static boolean stairCaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length-1;
        while(row<matrix.length && col>=0) {
            if(matrix[row][col]==key) {
                System.out.println("("+row+","+col+")");
                return true;
            }
            else if(key<matrix[row][col]){  //LEFT
                col--;
            }
            else{      //BOTTOM
                row++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {{10,20,30},
                          {15,25,35},
                          {32,33,39}};
        int key = 33;
        stairCaseSearch(matrix, key);
    }
}
