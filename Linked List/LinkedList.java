public class LinkedList {

    public static Node head;           // head
    public static Node tail;           // tail
    public static int size;            // size of ll

    public static class Node {         // node
        int data;                      // data of node
        Node next;                     // next of node
        public Node (int data) {       // constructor to create a node
            this.data = data;
            this.next = null;          // by default next of node is initialized as null
        }
    }

    public void addFirst(int data) {   // method to add an element at starting
        Node newNode = new Node(data); // creating a new node which we have to insert in LL
        size++;
        if(head == null) {             // if linked list is empty
            head = tail = newNode;
            return;   
        }
        newNode.next = head;           // newNode will point to the node, on which head is pointing
        head = newNode;                // update head i.e. newNode will be the head
    }

    public void addLast(int data) {    // method to add an element at end
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;           // the ending node (pointed by tail) will point to newNode
        tail = newNode;                // update tail i.e. newNode will be the tail
    }

    public void add_Last(int data) {   // add at last if we don't have the data of tail 
        Node newNode = new Node(data);
        size++;
        
        if(head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtIndex(int index, int data) {  // add an element at specific index
        if(index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        int i = 0;
        Node temp = head;
        while(i<index-1) {
            temp = temp.next;
            i++;
        }
        // now i = index-1
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int deleteFirst() {
        if(head == null) {                        // if ll is empty
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        }
        else if(head == tail) {                   // if ll has only one node.
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    
    public int deleteLast() {
        if(head==null) {
            System.out.println("ll is empty.");
            return Integer.MIN_VALUE;
        }
        else if(head == tail) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node secondLast = head;
        while(secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        // now we have reached secondLast at node
        int val = secondLast.next.data;
        secondLast.next = null;
        tail = secondLast;
        size--;
        return val;
    }

    public void deleteNode(int key) {      // delete a given node
        if(head==null) {
            return;
        }
        if(head.data==key) {               // if key is first node
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        Node prev = null;
        while(temp!=null && temp.data!=key) {  // keep traversing until key is found
            prev = temp;
            temp = temp.next;
        }
        if(temp==null) {                       // key not found
            return;
        }
        prev.next = temp.next;                // key is deleted.
        size--;
    }

    public void deleteAtIndex(int index) {
        if(head==null) {
            return;
        }
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        for(int i=0; temp!=null && i<index-1; i++) {
            temp = temp.next;
        }
        if(temp==null || temp.next==null) {          // if index is more than size of ll
            return;
        }
        temp.next = temp.next.next;                  // deleted the node
        size--;                  
    }

    public int itrSearch(int key) {         // iterative method to search a key
        Node temp = head;
        int i = 0;
        while(temp!=null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        // key not found
        return -1;
    }

    public int recSearch(int key) {         // recursive method to find a key
        return helper(head, key);
    }
    public int helper(Node head, int key) { // this helper method is actual recursive method
        if(head == null) {
            return -1;
        }
        if(head.data==key) {
            return 0;
        }
        int i = helper(head.next, key);  
        if(i==-1) {    // key not found
            return -1;
        }
        return i+1;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        tail = head;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // now curr is null so our prev wiil be head.
        head = prev;
    }

    public void print() {
        if(head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        Node temp = head;
        while(temp != null) {
            // System.out.print(temp.data + " ");
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addAtIndex(2, 3);
        ll.add_Last(6);
        ll.print();
        // System.out.println("Deleted node : " + ll.deleteFirst());
        // ll.print();
        // System.out.println("Deleted node : " + ll.deleteLast());
        // ll.print();
        // System.out.println("Size : " + size);
        // System.out.println("4 found at index : " + ll.itrSearch(4));
        // System.out.println("4 found at index : " + ll.recSearch(4));
        // ll.deleteNode(1);
        // ll.deleteAtIndex(3);
        // ll.print();
        // System.out.println("Size : " + size);
        ll.reverse();
        ll.print();
    }
}