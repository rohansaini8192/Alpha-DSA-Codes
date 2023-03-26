import java.util.LinkedList;
import java.util.Queue;

public class Traversing {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {
        static int i=-1;
        public static Node buildTree(int nodes[]) {
            i++;
            if(nodes[i]==-1) {
                return null;
            }
            // assuming that order of nodes if preorder
            Node newNode = new Node(nodes[i]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        public static void preorder(Node root) {
            if(root==null) {
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root) {
            if(root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root) {
            if(root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelOrder(Node root) {
            if(root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    }else{
                        q.add(null);
                    }
                }
                else {
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null)
                        q.add(currNode.left);
                    if(currNode.right!=null)
                        q.add(currNode.right);
                }
            }
        }
        public static int height(Node root) {
            if(root == null) {
                return 0;
            }
            // height of left and right subtree
            int lh = height(root.left);
            int rh = height(root.right);
            // height of tree
            return (Math.max(lh, rh) + 1);
        }
        public static int countOfNodes(Node root) {
            if(root==null) {
                return 0;
            }
            int lc = countOfNodes(root.left);
            int rc = countOfNodes(root.right);
            return lc+rc+1;
        }
        // diameter of tree
        static class Info {
            int diam,ht;
            public Info(int diam,int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }
        public static Info diameter(Node root) {
            if(root==null) {
                return new Info(0, 0);
            }
            Info lInfo = diameter(root.left);
            Info rInfo = diameter(root.right);
            int diam = Math.max(Math.max(lInfo.diam, rInfo.diam), lInfo.ht+rInfo.ht+1);
            int ht = Math.max(lInfo.ht, rInfo.ht)+1;
            return new Info(diam, ht);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};    // preorder
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.preorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.postorder(root);
        System.out.println();
        System.out.println("Level Order Traversal");
        tree.levelOrder(root);
        System.out.println("Height of the tree "+tree.height(root));
        System.out.println("No. of node in tree "+tree.countOfNodes(root));
        System.out.println("Diameter of tree "+tree.diameter(root).diam);
    }
}