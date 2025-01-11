import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<Node>[] adj;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    
    static class Node implements Comparable<Node> {
        int v, w;
        
        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }
        
        dist = new int[V+1];
        Arrays.fill(dist, INF);
        
        dijkstra(K);
        
        for(int i=1; i<=V; i++){
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
    
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int cv = cur.v;
            int cw = cur.w;
            
            if(dist[cv] < cw) continue;
            
            for(Node nx : adj[cv]){
                int nv = nx.v;
                int nw = cw + nx.w;
                
                if(dist[nv] > nw){
                    dist[nv] = nw;
                    pq.offer(new Node(nv, nw));
                }
            }
        }
    }
}