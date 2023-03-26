import java.util.*;

public class CheapestFlights {
    static class Edge {
        int src,dest,wt;
        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }
    static class Info {
        int v, path, stops;
        Info(int v, int path, int stops) {
            this.v = v;
            this.path = path;
            this.stops = stops;
        }
    }
    public static void createGraph(int flights[][], ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }
    public static int cheapestPrice(int n, int flights[][], int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights,graph);
        int dist[] = new int[n];
        for(int i=0; i<n; i++) {
            if(i!=src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                break;
            }
            for(Edge e : graph[curr.v]) {
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(curr.path + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.path + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return dist[dst];
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int flights[][] = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0, dst = 2, k=1;
        System.out.println(cheapestPrice(n, flights, src, dst, k));
    }
}
