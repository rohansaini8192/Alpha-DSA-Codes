import java.util.ArrayList;

public class LowestCommonAnsector {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    // Approach 1
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root==null) {
            return false;
        }
        path.add(root);
        if(root.data==n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if(foundLeft || foundRight) {
            return true;
        }
        //else 
        path.remove(path.size()-1);   // remove lastly added Node
        return false;
    }
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i=0;
        while(i<path1.size() && i<path2.size()) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
            i++;
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    // Approach 2
    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data==n1 || root.data==n2) {
            return root;
        }
        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);
        if(rightLCA == null) {
            return leftLCA;
        }
        if(leftLCA == null) {
            return rightLCA;
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        int n1 = 5, n2 = 6;
        System.out.println(lca(root, n1, n2).data);
        System.out.println(lca2(root, n1, n2).data);
    }
}
