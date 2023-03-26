import java.util.Stack;

public class SimplifyPath {
    public static String simplify(String str) {
        Stack<String> s = new Stack<>();
        // output will always have '/' so we will initialize our ans as "/"
        String ans = "/";
        for(int i=0; i<str.length(); i++) {
            String token = "";
            while(i<str.length() && str.charAt(i)=='/') {
                i++;
            }
            while(i<str.length() && str.charAt(i)!='/') {
                token += str.charAt(i);
                i++;
            }
            if(token.equals("..")) {
                s.pop();
            }
            else if(token.equals(".")) {
                continue;
            }
            else {
                s.push(token);
            }
        }
        // To print output path
        Stack<String> s1 = new Stack<>();
        // push stack s to stack s1
        while(!s.isEmpty()) {
            s1.push(s.pop());
        }
        // simplified path
        while(!s1.isEmpty()) {
            if(s1.size() > 1){
                ans += (s1.pop()+"/");
            }
            else {
                ans += s1.pop();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "/a/b/c/.././././//d";
        String str1 = "/home/";
        System.out.println(simplify(str));
        System.out.println(simplify(str1));
        
    }
}
