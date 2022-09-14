import java.util.ArrayList;
public class ForLoop {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(10);
        nums.add(3);
        nums.add(2);
        nums.add(4);

        for(Integer el: nums) {
            System.out.println(el);
        }
    }
}
