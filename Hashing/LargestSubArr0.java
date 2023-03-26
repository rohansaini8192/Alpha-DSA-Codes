import java.util.HashMap;

public class LargestSubArr0 {
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10,23};
        // map<sum,index>
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum)) {   //sum[0,j] == sum[0,i]
                int i = map.get(sum);
                ans = Math.max(ans, j-i);
            }
            else {
                map.put(sum, j);
            }
        }
        System.out.println(ans);
    }
}
