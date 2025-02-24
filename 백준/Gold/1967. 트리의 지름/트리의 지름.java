import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance, maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            tree[from].add(new Node(to, dist));
            tree[to].add(new Node(from, dist));
        }

        visited = new boolean[N+1];
        maxDistance = 0;
        dfs(1, 0);
        int A = maxNode;

        visited = new boolean[N+1];
        maxDistance = 0;
        dfs(A, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int current, int dist) {
        visited[current] = true;
        if(dist > maxDistance){
            maxDistance = dist;
            maxNode = current;
        }
        for(Node next : tree[current]){
            if(!visited[next.idx]) {
                dfs(next.idx, dist + next.dist);
            }
        }
    }

    static class Node {
        int idx, dist;
        public Node(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
}