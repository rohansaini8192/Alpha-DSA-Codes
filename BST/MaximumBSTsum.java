public class MaximumBSTsum {
    static class Node {
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
        }
    }
    static int maxSum = 0;
    static class Info {
        boolean isBST;
        int sum;
        int min;
        int max;
        public Info(boolean isBST, int sum, int min, int max){
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }
    public static Info maxBSTsum(Node root) {
        if(root==null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info L = maxBSTsum(root.left);
        Info R = maxBSTsum(root.right);
        // my info
        int sum = L.sum + R.sum + root.data;
        int min = Math.min(root.data,Math.min(L.min,R.min));
        int max = Math.max(root.data,Math.max(L.max,R.max));
        if(root.data <= L.max || root.data >= R.min) {
            return new Info(false, sum, min, max);
        }
        else if(L.isBST && R.isBST) {
            maxSum = Math.max(sum, maxSum);
            return new Info(true, sum, min, max);
        }
        return new Info(false, sum, min, max);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.right.right = new Node(3);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);
        maxBSTsum(root);
        System.out.println(maxSum);
    }    
}
