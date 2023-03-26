import java.util.*;

public class DoubleEndedQueue {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.add(1);
        dq.add(2);
        dq.addLast(3);
        dq.addLast(4);
        dq.addFirst(5);

        System.out.println(dq);
        System.out.println(dq.getFirst());
    }
}
