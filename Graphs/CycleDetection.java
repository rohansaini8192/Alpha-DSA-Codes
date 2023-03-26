import java.util.*;

public class CycleDetection {     // Undirected graph
    static class Edge {
        int src,dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detCycleUtil(graph, i, vis, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detCycleUtil(ArrayList<Edge> graph[],int curr,boolean vis[],int par) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            //case 1
            if(!vis[e.dest]) {
                if(detCycleUtil(graph, e.dest, vis, curr)) {
                    return true;
                }
            }
            // case 2
            else if(vis[e.dest] && e.dest != par) {
                return true;
            }
            // case 3 : continue
        }
        return false;
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

        System.out.println(detectCycle(graph));
    }
}
