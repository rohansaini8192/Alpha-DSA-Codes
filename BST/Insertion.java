import java.util.ArrayList;

public class Insertion {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    // insertion
    public static Node insert(Node root, int data) {
        Node newNode = new Node(data);
        if(root == null) {
            root = newNode;
            return root;
        }
        if(data < root.data) {
            root.left = insert(root.left, data);
        }
        else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    // search in BST
    public static boolean search(Node root, int key) {
        if(root==null) {
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(key < root.data) {
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }
    // deletion in BST 
    public static Node delete(Node root, int key) {
        if(root.data < key) {
            root.right = delete(root.right,key);
        }
        else if(root.data > key) {
            root.left = delete(root.left,key);
        }
        else {
            // case 1
            if(root.left == null && root.right == null) {
                return null;
            }
            // case 2
            else if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            // case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;   // copy IS to root
            root.right = delete(root.right,IS.data);  // delete IS
        }
        return root;
    }
    public static Node inorderSuccessor(Node root) {
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    // Print in Range
    public static void printInRange(Node root, int k1, int k2) {
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data > k2) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }
    public static void inorder(Node root) {
        if(root==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    // Root to leaf paths
    public static void rootToLeaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null) {
            printPath(path);
        }
        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }
    public static boolean validateBST(Node root, Node min, Node max){
        if(root==null){
            return true;
        }
        if(min != null && root.data < min.data){
            return false;
        }
        else if(max!=null && root.data > max.data){
            return false;
        }
        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }
    public static void main(String[] args) {
        int nodes[] = {3,5,2,8,1,7};
        Node root = null;
        for(int i=0; i<nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        inorder(root);
        System.out.println();
        System.out.println(search(root, 8));
        root = delete(root, 5);
        inorder(root);
        System.out.println();
        printInRange(root, 5, 8);
        System.out.println();
        rootToLeaf(root, new ArrayList<>());
        System.out.println(validateBST(root, null, null));
    }
}