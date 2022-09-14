public class maxIn2Darr {
    public static void min_max(int matrix[][]) {
        int min_index1=0,min_index2=0,max_index1=0,max_index2=0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                    min_index1 = i;
                    min_index2 = j;
                }
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                    max_index1 = i;
                    max_index2 = j;
                }
            }
        }
        System.out.println("Minimum no. is "+min+" present at cell "+"("+min_index1+","+min_index2+")");
        System.out.println("Maximum no. is "+max+" present at cell "+"("+max_index1+","+max_index2+")");
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},
                           {4,5,6},
                           {7,8,9}};
        min_max(matrix);
    }
}
