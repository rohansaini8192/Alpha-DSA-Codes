import java.util.LinkedList;

public class LLinCollectionsFramework {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.addLast("Saini");
        ll.addFirst("Kumar");
        ll.addFirst("Rohan");

        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        System.out.println(ll.size());
    }
}
