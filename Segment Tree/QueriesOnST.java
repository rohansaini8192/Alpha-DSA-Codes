public class QueriesOnST {
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
    // Range Sum
    public static int getSum(int arr[],int qi,int qj) {
        int n = arr.length;
        if(qi<0 || qj>n-1) {
            System.out.println("Invalid input.");
            return -1;
        }
        return getSumUtil(0,0,n-1,qi,qj);
    }
    public static int getSumUtil(int i,int si,int sj,int qi,int qj){
        if(qj<si || qi>sj) {      // Case 1
            return 0;
        }
        if(si>=qi && sj<=qj) {      // Case 2
            return tree[i];
        }
        // Case 3
        int mid = (si+sj)/2;
        int left = getSumUtil(2*i+1, si, mid, qi, qj);
        int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
        return left+right;
    }
    // Update
    public static void update(int arr[],int idx,int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0,0,n-1,idx,diff);
    }
    public static void updateUtil(int i,int si,int sj,int idx,int diff) {
        if(idx<si || idx>sj){
            return;
        }
        tree[i] += diff;
        if(si!=sj){  // non-leaf, so update children
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int arr[] = {1,3,-2,8,-7};
        init(n);
        buildST(arr, 0, 0, n-1);

        System.out.println(getSum(arr,1,3));
        update(arr, 1, 2);

        System.out.println(getSum(arr, 1, 3));
    }
}