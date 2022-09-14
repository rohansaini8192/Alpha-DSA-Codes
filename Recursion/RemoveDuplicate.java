public class RemoveDuplicate {
    public static void removeDup(String str, StringBuilder newStr, int i, boolean map[]) {
        if(i==str.length()){
            System.out.println(newStr);
            return;
        }
        char curr = str.charAt(i);
        if(map[curr-'a']==false){
            newStr.append(curr);
            map[curr-'a'] = true;
        }
        removeDup(str, newStr, i+1, map);
    }
    public static void main(String[] args) {
        String str = "helloworld";
        StringBuilder newStr = new StringBuilder("");
        boolean map[] = new boolean[26];
        removeDup(str, newStr, 0, map);
    }
}
