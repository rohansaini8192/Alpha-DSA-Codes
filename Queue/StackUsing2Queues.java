import java.util.Queue;
import java.util.LinkedList;

public class StackUsing2Queues {
    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty();
        }
        // Method 1
        // public void push(int data) {    // O(n)
        //     // add element in empty q2
        //     q2.add(data);
        //     // add all the remaining elements in q2 from q1
        //     while(!q1.isEmpty()) {
        //         q2.add(q1.remove());
        //     }
        //     // swap the names of two queues
        //     Queue<Integer> q = q1;
        //     q1 = q2;
        //     q2 = q;
        // }
        // public int pop() {           O(1)
        //     if(q1.isEmpty()) {
        //         System.out.println("Stack is empty.");
        //         return -1;
        //     }
        //     return q1.remove();
        // }
        // public int peek() {          O(1)
        //     if(q1.isEmpty()) {
        //         System.out.println("Stack is empty.");
        //         return -1;
        //     }
        //     return q1.peek();
        // }

        // Method 2
        public void push(int data) {         // O(1)
            q1.add(data);
        }
        public int pop() {                  // O(n)
            if(q1.isEmpty()) {
                System.err.println("Stack is Empty.");
                return -1;
            }
            // add all elements from q1 to q2 except last element
            while(q1.size() > 1) {
                q2.add(q1.remove());
            }
            // pop last element
            int top = q1.remove();
            // swap 
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
            return top;
        }
        public int peek() {                 // O(n)
            if(q1.isEmpty()) {
                System.err.println("Stack is Empty.");
                return -1;
            }
            // push all elements from q1 to q2 except last element
            while(q1.size() > 1) {
                q2.add(q1.remove());
            }
            // last element
            int top = q1.remove();
            q2.add(top);
            // swap 
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
            return top;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
