import java.util.ArrayList;
import java.util.Collections;

public class LonelyNum1 {
    // Optimized
    public static ArrayList<Integer> lonelyNums(ArrayList<Integer> list) {
        Collections.sort(list);                        // sort the given list
        ArrayList<Integer> ans = new ArrayList<>();
        int n = list.size();
        for(int i=1; i<n-1; i++) {                  // 1 to n-2
            if(list.get(i-1)+1 < list.get(i) && list.get(i)+1 < list.get(i+1)) {
                ans.add(list.get(i));
            }
        }
        if(n==1){
            ans.add(list.get(0));
        }
        if(n>1) {
            if(list.get(0)+1 < list.get(1)) {
                ans.add(list.get(0));                  // first element
            }
            if(list.get(n-2)+1 < list.get(n-1)) {
                ans.add(list.get(n-1));                      // last element
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(8);
        list.add(11);
        list.add(2);
        list.add(6);
        System.out.println(lonelyNums(list));
    }
}
