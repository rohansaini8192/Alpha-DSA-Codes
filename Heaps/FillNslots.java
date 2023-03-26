import java.util.*;

public class FillNslots {
    public static int minTime(int arr[], int N, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int time = 0;
        boolean visited[] = new boolean[N+1];
        // insert all filled slots in queue.
        for(int i=0; i<K; i++) {
            q.add(arr[i]);
            visited[arr[i]] = true;
        }
        while(q.size()>0){
            // iterate through all slots in queue
            for(int i=0; i<q.size(); i++) {
                int curr = q.remove();
                // if prev slot exists and not visited
                if(curr-1 >= 1 && !visited[curr-1]) {
                    visited[curr-1]=true;
                    q.add(curr-1);
                }
                // if next slot exists and not visited
                if(curr+1 <= N && !visited[curr+1]) {
                    visited[curr+1]=true;
                    q.add(curr+1);
                }
            }
            time++;
        }
        return time-1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int N=5;
        int K=arr.length;
        System.out.println(minTime(arr, N, K));
    }
}
