import java.util.*;

public class BinaryNumbers {
    public static void printBN(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n>0) {
            String s1 = q.remove();
            System.out.println(s1);
            q.add(s1+"0");
            q.add(s1+"1");
            n--;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        printBN(n);
    }
}