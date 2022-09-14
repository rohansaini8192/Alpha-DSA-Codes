public class TowerOfHanoi {
    public static void hanoi(int n, char src, char helper, char dest) {
        if(n==1) {
            System.out.println("Transfer disc "+ n +" from "+ src +" to "+ dest);
            return;
        }
        hanoi(n-1, src, dest, helper);
        System.out.println("Transfer disc "+ n +" from "+ src +" to "+ dest);
        hanoi(n-1, helper, src, dest);
    }
    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }
}
