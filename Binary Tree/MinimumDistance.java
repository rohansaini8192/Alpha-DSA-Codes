public class MinimumDistance {
    static class Node {
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static Node lca(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);
        if(rightLCA == null) {
            return leftLCA;
        }
        if(leftLCA == null) {
            return rightLCA;
        }
        return root;
    }
    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int dist1 = distFromLCA(lca, n1);
        int dist2 = distFromLCA(lca, n2);
        return dist1+dist2;
    }
    public static int distFromLCA(Node lca, int n) {
        if(lca == null) {
            return -1;
        }
        if(lca.data == n) {
            return 0;
        }
        int leftDist = distFromLCA(lca.left, n);   // n maybe in left subtree or right subtree
        int rightDist = distFromLCA(lca.right, n);
        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }
        else if(leftDist != -1) {
            return leftDist+1;
        }
        else{
            return rightDist+1;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 3;
        System.out.println(minDist(root, n1, n2));
    }
}
