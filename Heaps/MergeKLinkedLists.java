import java.util.PriorityQueue;

public class MergeKLinkedLists {
    static class Node implements Comparable<Node> {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
        @Override
        public int compareTo(Node n2) {
            return this.data - n2.data;
        }
    }
    public static Node mergeKLists(Node a[], int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // store heads of all linked lists in pq
        for(int i=0; i<k; i++){
            pq.add(a[i]);
        }
        Node head = new Node(0);
        Node ptr = head;
        // remove from pq and create merged linked list
        while(!pq.isEmpty()){
            Node curr = pq.remove();
            ptr.next = curr;
            ptr = ptr.next;
            if(curr.next!=null) {
                pq.add(curr.next);
            }
        }
        return head.next;   // because initial head we took 0 
    }
    public static void main(String[] args) {
        int k = 3;
        Node a[] = new Node[k];
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
        head3.next.next = new Node(10);
        head3.next.next.next = new Node(11);
        Node head = mergeKLists(a, k);
        while(head!=null) {
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println("null"); 
    }
}
