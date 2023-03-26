import java.util.*;

public class InterleaveHalves {
    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size()/2;
        for(int i=0; i<size; i++) {
            firstHalf.add(q.remove());
        }
        // interleaving
        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=10; i++) {
            q.add(i);
        }
        interLeave(q);
        // printing queue
        while(!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
    }
}
