import java.util.*;
public class palindrome {
    public static boolean isPalindrome(String str) {
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        System.out.println(isPalindrome(str));
    }
}