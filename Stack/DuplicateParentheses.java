import java.util.Stack;

public class DuplicateParentheses {
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')') {   // closing bracket
                int count = 0;
                while(s.pop() != '(') {
                    count++;
                }
                if(count == 0) {     // duplicate
                    return true;
                }
            }
            else {   // opening, operator, operand
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b)+c)";
        System.err.println(isDuplicate(str));
    }
}
