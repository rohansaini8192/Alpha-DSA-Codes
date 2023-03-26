import java.util.*;

public class CycleDet {
    static class Edge {
        int src,dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean recStack[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detCycleUtil(graph, i, vis, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean recStack[]) {
        vis[curr] = true;
        recStack[curr] = true;
        for(int i=0; i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(recStack[e.dest]) {     // neighbor is already in recStack
                return true;
            }
            if(!vis[e.dest]) {
                if(detCycleUtil(graph, e.dest, vis, recStack)) {
                    return true;
                }
            }
        }
        recStack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
        System.out.println(detectCycle(graph));
    }
}
