import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India", 150);
        map.put("China", 145);
        map.put("US",40);
        System.out.println(map);
        int value = map.get("US");
        System.out.println(value);
        // iteration over keys using for each loop
        for(String key : map.keySet()) {
            System.out.println("key: "+key);
        }
        // iteration over values using for each loop
        for(Integer val : map.values()) {
            System.out.println("Value: "+val);
        }
    }
}