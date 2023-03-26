import java.util.*;

public class TopSortBFS {     // topological sort using BFS (Kahn's Algo)
    static class Edge {
    int src,dest;
        Edge(int s, int d) {
        src = s;
        dest = d;
        }
    }
    public static void topoSort(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        int indeg[] = new int[graph.length];
        // calculate indegree of each vertex
        for(int i=0; i<graph.length; i++) {
            for(Edge e : graph[i]) {
                indeg[e.dest]++;
            }
        }
        // add vertex of indeg=0 into queue
        for(int i=0; i<graph.length; i++) {
            if(indeg[i]==0) {
                q.add(i);
            }
        }
        // perform bfs and find topological order
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");
            for(Edge e : graph[curr]) {
                indeg[e.dest]--;
                if(indeg[e.dest]==0) {
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        topoSort(graph);
    }
}
