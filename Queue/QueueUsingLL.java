public class QueueUsingLL {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Queue {
        static Node head = null;
        static Node tail = null;
        public boolean isEmpty() {
            return head == null && tail == null;
        }
        public void add(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public int remove() {
            if(isEmpty()) {
                System.err.println("Queue is empty.");
                return -1;
            }
            int front = head.data;
            if(head == tail) {  // queue has only one element
                head = tail = null;
            }
            else {
                head = head.next;
            }
            return front;
        }
        public int peek() {
            if(isEmpty()) {
                System.err.println("Queue is empty.");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
