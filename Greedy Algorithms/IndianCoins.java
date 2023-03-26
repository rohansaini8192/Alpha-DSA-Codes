import java.util.*;

public class IndianCoins {
    public static void minCoins(int coins[], int amount) {
        int count = 0;
        ArrayList<Integer> selectedCoins = new ArrayList<>();
        Arrays.sort(coins);
        for(int i=coins.length-1; i>=0; i--) {
            while(coins[i] <= amount) {
                count++;
                selectedCoins.add(coins[i]);
                amount -= coins[i];
            }
        }
        System.out.println("Minimum coins selected are " + count +" "+ selectedCoins);
    }
    public static void main(String[] args) {
        int coins[] = {1,2,5,10,20,50,100,200,500,2000};
        int amount = 580;
        minCoins(coins, amount);
    }
}
