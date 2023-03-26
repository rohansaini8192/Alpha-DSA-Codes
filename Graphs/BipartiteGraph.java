import java.util.*;

public class BipartiteGraph {
    static class Edge {
        int src,dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for(int i=0; i<color.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(color[i]==-1) {
                //BFS
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(Edge e : graph[curr]) {
                        if(color[e.dest]==-1) {
                            color[e.dest] = color[curr]==0 ? 1 : 0;
                            q.add(e.dest);
                        }
                        else if(color[e.dest]==color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));

        System.out.println(isBipartite(graph));
    }
}
