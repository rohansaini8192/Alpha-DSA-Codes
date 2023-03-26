import java.util.PriorityQueue;

public class WeakestSoldier {
    static class Row implements Comparable<Row> {
        int soldiers, idx;
        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row row2) {
            if(this.soldiers == row2.soldiers){
                return this.idx - row2.idx;
            }
            else{
                return this.soldiers - row2.soldiers;
            }
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            int soldiers = 0;
            for(int j=0; j<arr[0].length; j++) {
                soldiers += arr[i][j];
            }
            pq.add(new Row(soldiers, i));
        }
        for(int i=0; i<k; i++){
            System.out.println("R"+pq.remove().idx);
        }
    }
}
