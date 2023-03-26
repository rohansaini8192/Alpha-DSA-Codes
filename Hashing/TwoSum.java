import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int arr[], int k) {
        HashMap<Integer,Integer> map = new HashMap<>();  // <element,index>
        for(int j=0; j<arr.length; j++) {
            if(map.containsKey(k-arr[j])) {
                return new int[] {map.get(k-arr[j]),j};
            }
            map.put(arr[j],j);
        }
        return new int[] {0,0};
    }
    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int k = 18;
        int ans[] = twoSum(arr, k);
        System.out.print(ans[0]+","+ans[1]);
    }
}
