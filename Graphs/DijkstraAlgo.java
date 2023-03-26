import java.util.*;

public class DijkstraAlgo {
    static class Edge {
        int src,dest,wt;
        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }
    static class Pair implements Comparable<Pair> {
        int node,path;
        Pair(int n, int p) {
            node = n;
            path = p;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }
    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        boolean vis[] = new boolean[graph.length];
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i!=src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node] = true;
                for(Edge e : graph[curr.node]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u]+wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String[] args) {
        int V = 6;
        int src = 0;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        dijkstra(graph, src);
    }
}
