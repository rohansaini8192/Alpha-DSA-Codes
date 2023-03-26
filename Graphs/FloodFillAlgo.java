public class FloodFillAlgo {
    public static void helper(int image[][], int sr,int sc,int color,boolean vis[][],int oldColor) {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=oldColor) {
            return;
        }
        image[sr][sc] = color;
        vis[sr][sc] = true;
        helper(image, sr-1, sc, color, vis, oldColor);
        helper(image, sr+1, sc, color, vis, oldColor);
        helper(image, sr, sc-1, color, vis, oldColor);
        helper(image, sr, sc+1, color, vis, oldColor);
    }
    public static void floodfill(int image[][], int sr,int sc,int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,vis,image[sr][sc]);
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,1},
                        {1,1,0},
                        {1,0,1}};
        int sr=0, sc=1, color=2;
        floodfill(image,sr,sc,color);
        System.out.println("New image: ");
        for(int i=0; i<image.length; i++) {
            for(int j=0; j<image[0].length; j++) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
