public class DoublyLL {
    public static Node head;
    public static Node tail;
    public class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    public void removeFirst() {
        if(head==null) {
            return;
        }
        else if(head.next==null) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }
    public void removeLast() {
        if(head==null) {
            return;
        }
        else if(head.next==null) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            // update
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void print() {
        if(head==null) {
            System.out.println("DLL is empty.");
            return;
        }
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addLast(6);
        dll.addLast(7);
        dll.print();
        dll.reverse();
        dll.print();
    }
}