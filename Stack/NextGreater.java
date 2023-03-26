import java.util.Stack;

public class NextGreater {
    public static void nextGreater(int arr[], int nxtGrtr[]) {
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nxtGrtr[i] = -1;
            }
            else {
                nxtGrtr[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int nxtGrtr[] = new int[arr.length];
        nextGreater(arr, nxtGrtr);

        for(int i=0; i<nxtGrtr.length; i++) {
            System.err.print(nxtGrtr[i]+" ");
        }
    }
}
