public class MaxST {
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

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }
    // Max element of subarray
    public static int getMax(int arr[],int qi,int qj) {
        int n = arr.length;
        return getMaxUtil(0,0,n-1,qi,qj);
    }
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if(qj<si || qi>sj) {
            return Integer.MIN_VALUE;
        }
        if(si>=qi && sj<=qj) {
            return tree[i];
        }
        int mid = (si+sj)/2;
        int leftMax = getMaxUtil(2*i+1, si, mid, qi, qj);
        int rightMax = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
        return Math.max(leftMax, rightMax);
    }
    // update a value
    public static void update(int arr[],int idx, int newVal) {
        arr[idx] = newVal;
        int n = arr.length;
        updateUtil(0,0,n-1,idx,newVal);
    }
    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if(idx<si || idx>sj) {
            return;
        }
        if(si==sj) {       // leaf node
            tree[i] = newVal;
            return; 
        }
        // non-leaf
        tree[i] = Math.max(tree[i], newVal);
        int mid = (si+sj)/2;
        updateUtil(2*i+1, si, mid, idx, newVal);
        updateUtil(2*i+2, mid+1, sj, idx, newVal);
    }
    public static void main(String[] args) {
        int n = 5;
        int arr[] = {1,3,-2,8,-7};
        init(n);
        buildST(arr, 0, 0, n-1);
        
        System.out.println(getMax(arr, 1, 3));
        update(arr, 2, 10);
        System.out.println(getMax(arr, 1, 3));
    }
}