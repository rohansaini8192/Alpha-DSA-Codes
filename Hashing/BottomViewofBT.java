import java.util.*;
public class BottomViewofBT {
    static class Node {
        int data;
        int hzd;
        Node left,right;
        public Node(int data) {
            this.data = data;
            this.hzd = Integer.MAX_VALUE;
        }
    }
    public static void printBottomView(Node root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();   // level order traversing
        root.hzd = 0;
        q.add(root);
        while(!q.isEmpty()) {
            Node curr = q.remove();
            map.put(curr.hzd, curr.data);
            if(curr.left != null) {
                curr.left.hzd = curr.hzd-1;
                q.add(curr.left);
            }
            if(curr.right != null) {
                curr.right.hzd = curr.hzd+1;
                q.add(curr.right);
            }
        }
        for(Integer key : map.keySet()) {
            System.out.print(map.get(key)+" ");
        }
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(26);
        root.left.right.right = new Node(14);
        root.left.right.left = new Node(10);
        printBottomView(root);
    }
}
