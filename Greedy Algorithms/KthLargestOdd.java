public class KthLargestOdd {
    public static void main(String[] args) {
        int L=-3, R=3, k=1;
        while(R>=L && k>0) {
            if(R%2!=0) {
                k--;
            }
            R--;
        }
        if(k==0) {
            System.out.println(R+1);
        }
        else {
            System.out.println("0");
        }
    }
}
