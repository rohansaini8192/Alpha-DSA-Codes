import java.util.Scanner;

public class LinkedList1 {
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
        if(head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void delete_NthNode_FromLast(int n) {
        // calculate size of ll
        int size = 0;
        Node temp = head;
        while(temp!=null) {
            temp = temp.next;
            size++;
        }

        // remove (size-n+1)th node from starting
        if(n==size) {   // delete first node
            head = head.next;
            return;
        }
        Node prev = head;
        int i = 1;
        while(i<size-n) {
            prev = prev.next;
            i++;
        }
        // prev has reached to (size-n)th node
        prev.next = prev.next.next;
    }

    public void print() {
        if(head==null) {
            System.out.println("ll is empty");
            return;
        }
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList1 ll = new LinkedList1();
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Enter a node: ");
            int data = sc.nextInt();
            ll.addNode(data);
            System.out.println("Press 1 to add more nodes, else 0:");
            choice = sc.nextInt();
        }while(choice==1);
        ll.print();

        System.out.println("Enter nth node to be deleted from last:");
        int n = sc.nextInt();
        ll.delete_NthNode_FromLast(n);
        sc.close();
        ll.print();
    }
}
