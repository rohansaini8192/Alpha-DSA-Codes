public class CircularLL {
    public static Node last;
    public class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(last==null) {
            last = newNode;
            newNode.next = last;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(last==null) {
            last = newNode;
            newNode.next = last;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
    }
    public void print() {
        if(last==null) {
            System.out.println("CLL is empty.");
            return;
        }
        Node temp = last.next;
        do {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }while(temp != last.next);
    }
    public static void main(String[] args) {
        CircularLL cll = new CircularLL();
        cll.addFirst(4);
        cll.addFirst(3);
        cll.addLast(5);
        cll.addLast(6);
        cll.print();
    }
}