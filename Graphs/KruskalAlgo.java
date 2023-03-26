import java.util.*;
public class KruskalAlgo {
    static class Edge implements Comparable<Edge> {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
        @Override 
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        } 
    }
    static int n = 4;
    static int par[] = new int[n]; 
    static int rank[] = new int[n];
    public static void init() {
        for(int i=0; i<n; i++) {
            par[i] = i;
        }
    }
    public static int find(int x) {
        if(x==par[x]) {
            return x;
        }
        par[x] = find(par[x]);
        return par[x];
    }
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if(rank[parA]==rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        }
        else {
            par[parB] = parA;
        }
    }
    public static int kruskalMST(ArrayList<Edge> edges) {
        init();
        Collections.sort(edges);
        int mstCost = 0;
        for(int i=0; i<edges.size(); i++) {
            Edge e = edges.get(i);
            int parS = find(e.src);
            int parD = find(e.dest);
            if(parS != parD) {
                union(e.src,e.dest);
                mstCost += e.wt;
            }
        }
        return mstCost;
    }
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
        System.out.println(kruskalMST(edges));
    }
}
