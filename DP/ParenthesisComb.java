public class ParenthesisComb {
    static int count = 0;
    public static void printParentheses(char str[],int n,int pos,int open,int close) {
        if(n==0) {
            return;
        }
        if(open==n && close==n) {          // base case
            for(int i=0; i<2*n; i++) {
                System.out.print(str[i]);
            }
            count++;
            System.out.println();
            return;
        }
        if(open<n) {
            str[pos] = '{';
            printParentheses(str, n, pos+1, open+1, close);
        }
        if(close<open) {
            str[pos] = '}';
            printParentheses(str, n, pos+1, open, close+1);
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char str[] = new char[2*n];
        printParentheses(str, n, 0, 0, 0);
        System.out.println(count);
    }
}
