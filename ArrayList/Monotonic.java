import java.util.ArrayList;

public class Monotonic {
    public static boolean isMonotic(ArrayList<Integer> list) {
        boolean flag1=true, flag2=true;
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                flag1 = false;
            }
            if(list.get(i) < list.get(i+1)) {
                flag2 = false;;
            }
        }
        return flag1 || flag2;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(3);
        System.out.println(isMonotic(list));
    }
}
