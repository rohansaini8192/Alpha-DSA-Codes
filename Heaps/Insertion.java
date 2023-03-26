import java.util.ArrayList;

public class Insertion {
    static class Heap {          // min heap
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x = arr.size()-1; // child index
            int par = (x-1)/2;    // parent index
            while(arr.get(x) < arr.get(par)) {
                // swap parent and child
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x-1)/2;
            }
        }
        public int peek() {
            return arr.get(0);
        }
        public int delete() {
            int key = arr.get(0);
            // step 1 - swap
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            // step 2 - delete last
            arr.remove(arr.size()-1);
            // step 3 - heapify
            heapify(0);
            return key;
        }
        private void heapify(int i) {
            int minIdx = i;
            int left = 2*i+1;
            int right = 2*i+2;
            if(left<arr.size() && arr.get(left)<arr.get(minIdx)){
                minIdx = left;
            }
            if(right<arr.size() && arr.get(right)<arr.get(minIdx)){
                minIdx = right;
            }
            if(minIdx != i){
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }
        public boolean isEmpty() {
            return arr.size()==0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(5);
        h.add(2);
        h.add(4);
        h.add(1);
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.delete();
        }
    }
}