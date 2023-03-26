import java.util.Comparator;
import java.util.PriorityQueue;

public class HalfArrSum {
    public static int minOP(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0,count=0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            pq.add(arr[i]);
        }
        double temp = sum;
        while(temp > sum/2) {
            int x = pq.remove();
            temp -= Math.ceil(x/2.0);   // ceiling function takes double as input
            pq.add(x/2);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1,5,8,19};
        System.out.println(minOP(arr));
    }
}
