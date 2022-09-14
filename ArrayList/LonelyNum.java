import java.util.ArrayList;

public class LonelyNum {
    // Brute force
    public static ArrayList<Integer> lonelyNums(ArrayList<Integer> list) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            int num = list.get(i);
            boolean flag = true;
            for(int j=0; j<list.size(); j++) {
                if(i!=j){
                    if(num==list.get(j) || num+1==list.get(j) || num-1==list.get(j)) {
                        flag = false;
                    }
                }
            }
            if(flag==true) {
                ans.add(num);
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