public class CycleInLinkedList {
    public static Node head;
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // method to check if cycle(loop) exists or not ---> Floyd's cycle finding algorithm
    public static boolean checkCycle() {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // step1- detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                cycle = true;
                break;
            }
        }
        if(cycle==false) {
            return;
        }

        // step2- slow = head
        slow = head;

        // step3 - move slow and fast by 1 till they meet
        Node prev = null;
        while(slow!=fast) {
            prev = fast;            
            slow = slow.next;
            fast = fast.next;
        }
        
        // step4- remove cycle-  lastNode.next = null
        prev.next = null;
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;

        System.out.println(checkCycle());
        removeCycle();
        System.out.println(checkCycle());
    }
}
