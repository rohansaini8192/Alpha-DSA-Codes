import java.util.*;

public class AdjacencyList {
    static class Edge {
        int src,dest,wt;
        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // vertex 0
        graph[0].add(new Edge(0, 1, 3));
        // vertex 1
        graph[1].add(new Edge(1, 0, 3));
        graph[1].add(new Edge(1, 2, -1));
        graph[1].add(new Edge(1, 3, 2));
        // vertex 2
        graph[2].add(new Edge(2, 1, -1));
        graph[2].add(new Edge(2, 3, 4));
        // vertex 3
        graph[3].add(new Edge(3, 2, 4));
        graph[3].add(new Edge(3, 1, 2));
        // print 1's neighbours
        for(int i=0; i<graph[1].size(); i++) {
            Edge e = graph[1].get(i);
            System.out.print(e.dest+" ");
        }
    }
}