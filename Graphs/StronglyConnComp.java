import java.util.*;

public class StronglyConnComp {
    static class Edge {
        int src,dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
    public static void topsort(ArrayList<Edge>[] graph,int curr,boolean vis[],Stack<Integer> st) {
        vis[curr] = true;
        for(Edge e: graph[curr]) {
            if(!vis[e.dest]) {
                topsort(graph, e.dest, vis, st);
            }
        }
        st.push(curr);
    }
    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr+" ");
        for(Edge e: graph[curr]) {
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge>[] graph, int V) {
        // step 1
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                topsort(graph,i,vis,st);
            }
        }
        // step 2
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for(int i=0; i<V; i++) {
            transpose[i] = new ArrayList<>();
            vis[i] = false;        // re-initialize visited array
        }
        for(int i=0; i<V; i++) {
            for(Edge e: graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        // step 3
        while(!st.isEmpty()){
            int curr = st.pop();
            if(!vis[curr]) {
                System.out.print("SCC: ");
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
        kosaraju(graph, V);
    }
}
