public class diagonalSum{
    /*  Brute Force
    public static int diagonal(int matrix[][]) {
        int sum = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                // PD
                if(i==j){
                    sum += matrix[i][j];
                }
                // SD
                else if(i+j == matrix.length-1){
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    } */

    // Optimised code
    public static int diagonal(int matrix[][]) {
        int sum = 0;
        for(int i=0; i<matrix.length; i++){
            // PD
            sum += matrix[i][i];
            // SD
            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},
                           {4,5,6},
                           {7,8,9}};
        System.out.println(diagonal(matrix));
    }
}