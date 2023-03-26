import java.util.HashSet;

public class UnionIntersec {
    public static void main(String[] args) {
        int arr1[] = {3,4,5,2,1,6,7};
        int arr2[] = {9,2,6};
        HashSet<Integer> set = new HashSet<>();
        // Union
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println("Union ");
        for(Integer key : set) {
            System.out.print(key+" ");
        }
        System.out.println();
        // Intersection
        set.clear();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        System.out.println("Intersection ");
        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])){
                System.out.print(arr2[i]+" ");
                set.remove(arr2[i]);
            }
        }
    }
}
