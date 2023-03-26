import java.util.Stack;

public class ReverseString {
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder revStr = new StringBuilder("");
        while(!s.isEmpty()) {
            revStr.append(s.pop());
        }
        return revStr.toString();
    }
    public static void main(String[] args) {
        String str = "rohan";
        System.err.println(reverseString(str));
    }
}
