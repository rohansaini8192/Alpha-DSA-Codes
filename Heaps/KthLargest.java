import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int arr[] = {10,20,11,70,50,40,100,5};
        int k = 3;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            if(min.size()<k) {
                min.add(arr[i]);
            }
            else {
                if(arr[i]>min.peek()){
                    min.remove();
                    min.add(arr[i]);
                }
            }
            if(min.size()>=k) {
                System.out.print(min.peek()+" ");
            }
            else{
                System.out.print("-1 ");
            }
        }
    }
}
