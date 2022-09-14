public class MergeSort {
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

    // function to find mid Node
    private Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // mergeSort
    public Node mergeSort(Node head) {
        if(head==null || head.next==null) {
            return head;
        }
        // find mid
        Node mid = findMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        // mergeSort left
        Node newLeft = mergeSort(head);
        // mergeSort right
        Node newRight = mergeSort(rightHead);
        // merge
        return merge(newLeft, newRight);
    }

    // merge function
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        // remaining
        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public static void main(String[] args) {
        MergeSort ll = new MergeSort();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.print();

        head = ll.mergeSort(head);
        ll.print();
    }
}
