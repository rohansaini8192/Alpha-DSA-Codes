import java.util.Stack;

public class QueueUsing2Stacks {
// Method 1 : enqueue operation costly
//     static class Queue {
//         Stack<Integer> s1 = new Stack<>();
//         Stack<Integer> s2 = new Stack<>();
//         public boolean isEmpty() {
//             return s1.isEmpty();
//         }
//         public void add(int data) {     // O(n)
//             while(!s1.isEmpty()) {
//                 s2.push(s1.pop());
//             }

//             s1.push(data);

//             while(!s2.isEmpty()) {
//                 s1.push(s2.pop());
//             }
//         }
//         public int remove() {            // O(1)
//             if(isEmpty()) {
//                 System.out.println("Empty queue.");
//                 return -1;
//             }
//             return s1.pop();
//         }
//         public int peek() {             // O(1)
//             if(isEmpty()) {
//                 System.out.println("Empty queue.");
//                 return -1;
//             }
//             return s1.peek();
//         }
//     }

// Method 2 : dequeue operation costly
    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        public boolean isEmpty() {
            return s1.isEmpty();
        }
        public void add(int data) {         // O(1)
            s1.push(data);
        }
        public int remove() {             // O(n)
            if(isEmpty()) {
                System.out.println("Empty queue.");
                return -1;
            }
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int front = s2.pop();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return front;
        }
        public int peek() {              // O(n)
            if(isEmpty()) {
                System.out.println("Empty queue.");
                return -1;
            }
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int front = s2.peek();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return front;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
