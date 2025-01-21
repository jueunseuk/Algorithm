import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX = 200000;
    static int[] parent = new int[MAX + 1];
    static boolean[] visit = new boolean[MAX + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);
        printPath(start, end);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        parent[start] = -1;

        while (!q.isEmpty()) {
            int current = q.poll();
            
            if (current == end) return;

            for (int next : new int[]{current + 1, current - 1, current * 2}) {
                if (next >= 0 && next <= MAX && !visit[next]) {
                    visit[next] = true;
                    parent[next] = current;
                    q.offer(next);
                }
            }
        }
    }

    private static void printPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        
        for (int at = end; at != -1; at = parent[at]) {
            path.add(at);
        }
        
        Collections.reverse(path);

        System.out.println(path.size() - 1);
        
        StringBuilder sb = new StringBuilder();
        for (int position : path) {
            sb.append(position).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}