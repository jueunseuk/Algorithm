import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M, V;
    static boolean[][] adjMatrix;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 시작 지점
        
        adjMatrix = new boolean[N + 1][N + 1];
        
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = adjMatrix[to][from] = true;
        }
        
        dfs(V, new boolean[N + 1]);
        bfs();
        
        System.out.println(dfsResult.toString().trim());
        System.out.println(bfsResult.toString().trim());
        
        br.close();
    }
    
    private static void dfs(int current, boolean[] visited) {
        visited[current] = true;
        dfsResult.append(current).append(" ");
        
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adjMatrix[current][i]) {
                dfs(i, visited);
            }
        }
    }
    
    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        
        queue.offer(V);
        visited[V] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            bfsResult.append(current).append(" ");
            
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && adjMatrix[current][i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
