import java.util.Arrays;

public class LexicoSmall {
    public static void main(String[] args) {
        int n=3, k=25;
        char str[] = new char[n];
        Arrays.fill(str, 'a');
        for(int i=n-1; i>=0; i--) {
            k -= i;
            if(k>0) {
                if(k>=26) {     // z needs to be added
                    str[i] = 'z';
                    k -= 26;
                }
                else {          // add required char
                    str[i] = (char)(k+96);
                    k -= (str[i]-96);
                }
            }
            else {
                break;
            }
            k += i;
        }
        System.out.println(new String(str));
    }
}