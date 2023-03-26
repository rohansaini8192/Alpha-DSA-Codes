import java.util.*;

public class ArticulationPoint {  // using tarjans algo
    static class Edge {
        int src,dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
    public static void dfs(ArrayList<Edge>[] graph,int curr,int par,int dt[],int low[],
                            boolean vis[],boolean AP[],int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(Edge e: graph[curr]) {
            if(e.dest == par) {
                continue;
            }
            else if(!vis[e.dest]) {
                dfs(graph, e.dest, curr, dt, low, vis, AP, time);
                low[curr] = Math.min(low[curr],low[e.dest]);
                if(par != -1 && dt[curr] <= low[e.dest]) {
                    AP[curr] = true;
                }
                children++;
            }
            else {
                low[curr] = Math.min(low[curr],dt[e.dest]);
            }
        }
        if(par == -1 && children>1){
            AP[curr] = true;
        }
    }
    public static void getAP(ArrayList<Edge>[] graph, int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        
        boolean vis[] = new boolean[V];
        boolean AP[] = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(graph,i,-1,dt,low,vis,AP,time);
            }
        }

        for(int i=0; i<V; i++) {
            if(AP[i]) {
                System.out.println("AP: "+i);
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        getAP(graph,V);
    }
}
