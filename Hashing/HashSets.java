import java.util.HashSet;
import java.util.Iterator;

public class HashSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(1);
        set.add(2);
        System.out.println(set);
        // iteration on HashSets
        // method 1
        Iterator i = set.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
        // method 2
        for(Integer key : set) {
            System.out.println(key);
        }
    }
}
