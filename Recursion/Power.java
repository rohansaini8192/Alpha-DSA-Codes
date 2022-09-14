public class Power {
    public static int optimizedPower(int x, int n) {
        if(n==0){
            return 1;
        }
        int halfPower = optimizedPower(x, n/2);
        int ans = halfPower*halfPower;
        if(n%2!=0){
            ans = x*ans;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(optimizedPower(2,10));
    }
}
