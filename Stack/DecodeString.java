import java.util.Stack;

public class DecodeString {
    public static String decode(String str) {
        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> charstack = new Stack<>();
        String result = "";
        // traverse the string
        for(int i=0; i<str.length(); i++) {
            int count = 0;
            // if digit : push it onto the integerstack
            if(Character.isDigit(str.charAt(i))) {
                while(Character.isDigit(str.charAt(i))) {
                    count = count*10 + (str.charAt(i) - '0');
                    i++;
                }
                integerstack.push(count);
                i--;
            }
            // if opening bracket '[' : push it onto the charstack
            else if(str.charAt(i) == '[') {
                if(Character.isDigit(str.charAt(i-1))) {
                    charstack.push(str.charAt(i));
                }
                else {
                    charstack.push(str.charAt(i));
                    integerstack.push(1);
                }
            }
            // if closing bracket ']' : pop chars from char stack till opening bracket '['
            // is not found and do following...
            else if(str.charAt(i) == ']') {
                String temp = "";
                count = integerstack.pop();
                while(charstack.peek() != '[') {
                    temp = charstack.pop() + temp;  //don't write: temp=temp+charstack.pop()
                }
                // also pop this opening bracket
                if(charstack.peek() == '[') {
                    charstack.pop();
                }
                // repeat the string temp 'count' no. of times
                for(int j=0; j<count; j++) {
                    result += temp;
                }
                // now push this result onto charstack
                for(int j=0; j<result.length(); j++) {
                    charstack.push(result.charAt(j));
                }
                result = "";
            }
            else {   // if characters : push onto the charstack
                charstack.push(str.charAt(i));
            }
        }
        // now pop all elements, make output string
        while(!charstack.isEmpty()) {
            result = charstack.pop() + result;  //don't write: result=result+charstack.pop()
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "3[b2[ca]]";
        System.out.println(decode(str));
    }
}
