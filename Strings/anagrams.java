import java.util.Arrays;
import java.util.Scanner;
public class anagrams {
    public static boolean isAnagrams(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length()==str2.length()){
            char[] str1Array = str1.toCharArray();
            char[] str2Array = str2.toCharArray();
            Arrays.sort(str1Array);
            Arrays.sort(str2Array);
            return Arrays.equals(str1Array, str2Array);
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string1: ");
        String str1 = sc.next();
        System.out.println("Enter string2: ");
        String str2 = sc.next();
        sc.close();
        System.out.println(isAnagrams(str1, str2));
    }
}
