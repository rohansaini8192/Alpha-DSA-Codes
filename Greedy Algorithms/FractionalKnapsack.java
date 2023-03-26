import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static int maxProfit(int weight[], int value[], int capacity) {
        double ratio[][] = new double[weight.length][2];
        int ans = 0;
        for(int i=0; i<weight.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double)value[i]/weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for(int i=ratio.length-1; i>=0; i--) {
            int idx = (int)ratio[i][0];
            // include full item if
            if(capacity >= weight[idx]) {
                ans += value[idx];
                capacity -= weight[idx];
            }
            else {  // include fraction of item
                ans += (ratio[i][1]*capacity);
                capacity = 0;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int weight[] = {10,20,30};
        int value[] = {60,100,120};
        int capacity = 50;
        System.out.println(maxProfit(weight, value, capacity));
    }
}
