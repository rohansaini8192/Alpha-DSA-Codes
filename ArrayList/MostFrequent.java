import java.util.ArrayList;

public class MostFrequent {
    // Most frequent number following a key
    public static int mostFrequentNum(ArrayList<Integer> nums, int key) {
        int map[] = new int[1000];
        int maxFreq = 0;
        int ans = 0;
        for(int i=0; i<nums.size()-1; i++) {
            if(nums.get(i) == key) {
                map[nums.get(i+1)]++;
                if(maxFreq < map[nums.get(i+1)]) {
                    maxFreq = map[nums.get(i+1)];
                    ans = nums.get(i+1);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(10);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        nums.add(2);
        nums.add(4);
        int key = 2;
        System.out.println(mostFrequentNum(nums, key));
    }
}
