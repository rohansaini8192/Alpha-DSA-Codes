public class PalindromeLinkedList {
    public static Node head; 
    public static Node tail;
    public class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void addNode(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public Node findMid() {
        Node slow = head;     // turtle
        Node fast = head;     // hare
        while(fast!=null && fast.next!=null) {
            slow = slow.next;          // +1
            fast = fast.next.next;     // +2
        }
        return slow;
    }

    public boolean isPalindrome() {
        if(head==null || head.next==null) {
            return true;
        }
        // step 1 - find mid node
        Node midNode = findMid();

        // step 2 - reverse 2nd half ll
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // step 3 - compare elements of left ll and right ll
        while(right!=null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList ll = new PalindromeLinkedList();
        ll.addNode(1);
        ll.addNode(2);
        ll.addNode(5);
        ll.addNode(2);
        ll.addNode(1);

        System.out.println(ll.isPalindrome());
    }
}
