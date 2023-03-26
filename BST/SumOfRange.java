public class SumOfRange {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    static int sum = 0;
    public static void findSum(Node root, int L, int R){
        if(root==null){
            return;
        }
        if(root.data >= L && root.data <= R) {
            findSum(root.left, L, R);
            sum = sum + root.data;
            findSum(root.right, L, R);
        }
        else if(root.data > R) {
            findSum(root.left, L, R);
        }
        else{
            findSum(root.right, L, R);
        }
    }
    // closest element
    static int min_diff = Integer.MAX_VALUE;
    static int element = -1;
    public static void findClosest(Node root, int k) {
        if(root == null) {
            return;
        }
        if(root.data == k) {
            min_diff = 0;
            element = root.data;
            return;
        }
        if(min_diff > Math.abs(root.data-k)) {
            min_diff = Math.abs(root.data-k);
            element = root.data;
        }
        if(root.data > k) {
            findClosest(root.left, k);
        }
        else{
            findClosest(root.right, k);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.right = new Node(20);
        findSum(root, 8, 50);
        System.out.println(sum);
        findClosest(root, 10);
        System.out.println("Closest element is "+element+" with min diff "+min_diff);
    }
}