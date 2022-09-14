public class ZigZagLL {
    public static Node head;
    public class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void print() {
        if(head == null) {
            System.out.println("LL is empty.");
            return;
        }
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // zigzag merging
    public void zigzag(Node head) {
        Node mid = findMid(head);

        // reverse second half
        Node prev = null;
        Node curr = mid.next;
        Node next;
        mid.next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        // zigzag connection
        while(left!=null && right!=null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    public static void main(String[] args) {
        ZigZagLL ll = new ZigZagLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.print();
        ll.zigzag(head);
        ll.print();
    }
}
