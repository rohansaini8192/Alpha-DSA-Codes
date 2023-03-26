public class SortedArrToBST {  // Sorted Array to balanced BST
    static class Node {
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node createBST(int arr[], int si, int ei) {
        if(si > ei) {
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, si, mid-1);
        root.right = createBST(arr, mid+1, ei);
        return root;
    }
    public static void preorder(Node root) {
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        Node root = createBST(arr, 0, arr.length-1);
        preorder(root);
    }
}
