import java.util.Stack;

public class PalindromeLL {
    public static Node head;
    public static class Node {
        char data;
        Node next;
        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void print(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static boolean isPalindrome(Node head) {
        Stack<Character> s = new Stack<>();
        // push the elements of ll in stack
        Node temp = head;
        while(temp!=null) {
            s.push(temp.data);
            temp = temp.next;
        }
        // pop one by one and compare
        while(head!=null) {
            if(head.data!=s.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node one = new Node('A');
        Node two = new Node('B');
        Node three = new Node('C');
        Node four = new Node('B');
        Node five = new Node('A');
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        head = one;
        print(head);
        System.out.println(isPalindrome(head));
    }
}
