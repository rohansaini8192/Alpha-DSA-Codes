import java.util.*;

public class Topological {    // topological sort using DFS
    static class Edge {
        int src,dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
    public static void topoSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topoSortUtil(graph, i, vis, st);
            }
        }
        System.out.println("Topological Sorted order of graph: ");
        while(!st.isEmpty()) {
            System.out.print(st.pop()+" ");
        }
    }
    public static void topoSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> st) {
        vis[curr] = true;
        for(Edge e: graph[curr]) {
            if(!vis[e.dest]) {
                topoSortUtil(graph, e.dest, vis, st);
            }
        }
        st.push(curr);
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
        topoSort(graph);
    }
}
