public class clearRange {
    public static int clearBitRange(int n, int i, int j) {
        int a = (~0)<<(j+1);
        int b = (1<<i) - 1;
        int bitMask = a|b;
        return (n & bitMask);
    }
    public static void main(String[] args) {
        System.out.println(clearBitRange(31, 1, 3));
    }
}
