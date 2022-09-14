import java.util.ArrayList;

public class MultidimensionalArrList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i=0; i<=4; i++) {
            list1.add(i+1);
            list2.add(i+3);
            list3.add(i+5);
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        System.out.println(mainList);

        System.out.println("In matrix form");
        for(int i=0; i<mainList.size(); i++){
            ArrayList<Integer> currList = mainList.get(i);  // for i=0, list1 will be stored in currList
            for(int j=0; j<currList.size(); j++) {
                System.out.print(currList.get(j)+ " ");
            }
            System.out.println();
        }

        // the lists in mainList may be of different size.
        // lets us remove some elements from list2
        list2.remove(1);
        list2.remove(2);
        System.out.println(mainList);
        System.out.println("In matrix form");
        for(int i=0; i<mainList.size(); i++){
            ArrayList<Integer> currList = mainList.get(i);
            for(int j=0; j<currList.size(); j++) {
                System.out.print(currList.get(j)+ " ");
            }
            System.out.println();
        }
    }
}
