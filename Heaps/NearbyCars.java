import java.util.PriorityQueue;

public class NearbyCars {
    static class Point implements Comparable<Point> {
        int x,y,idx;
        int distSq;
        public Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            distSq = x*x + y*y;
        }
        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;    // ascending order
        }
    }
    public static void main(String[] args) {
        int points[][] = {{3,3},{5,-1},{-2,4}};
        int k=2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<points.length; i++) {
            pq.add(new Point(points[i][0], points[i][1], i));
        }
        System.out.println("K nearest cars:");
        for(int i=0; i<k; i++) {
            System.out.println("C"+pq.remove().idx);
        }
    }
}
