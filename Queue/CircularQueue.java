public class CircularQueue {
    static class Queue {
        static int arr[];
        static int size;
        static int front;
        static int rear;
        Queue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }
        public boolean isFull() {
            return (rear+1)%size == front;
        }
        public void add(int data) {
            if(isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if(front == -1) {     // add 1st element
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int del = arr[front];
            if(rear == front) {    // if queue has only one element
                front = rear = -1;
            }
            else {
                front = (front+1)%size;
            }
            return del;
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.remove();
        q.add(5);
        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
