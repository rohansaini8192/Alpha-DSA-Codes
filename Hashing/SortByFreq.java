import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFreq {
    public static String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(Map.Entry<Character,Integer> e: map.entrySet()) {
            pq.add(e);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char ch = pq.peek().getKey();
            int freq = pq.remove().getValue();
            while(freq>0) {
                sb.append(ch);
                freq--;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "ccaabaccb";
        System.err.println(frequencySort(s));
    }
}
