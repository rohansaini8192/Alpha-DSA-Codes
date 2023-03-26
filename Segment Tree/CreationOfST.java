public class CreationOfST {
    static int tree[];
    public static void init(int n) {
        tree = new int[4*n];
    }
    public static void buildST(int arr[],int i,int start,int end) {
        if(start==end) {
            tree[i] = arr[start];
            return;
        }
        int mid = (start+end)/2;
        buildST(arr, 2*i+1, start, mid); // left subtree
        buildST(arr, 2*i+2, mid+1, end); // right subtree

        tree[i] = tree[2*i+1] + tree[2*i+2];
    }
    public static void main(String[] args) {
        int n = 5;
        int arr[] = {1,3,-2,8,-7};
        init(n);
        buildST(arr, 0, 0, n-1);
        System.out.println("Segment tree: ");
        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i]+" ");
        }
    }
}