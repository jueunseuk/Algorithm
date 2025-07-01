import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final long INF = Long.MAX_VALUE / 4;

    static int n, m, s, e;
    static long budget;
    static List<List<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        budget = Long.parseLong(st.nextToken());

        int maxEdge = 0;
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
            maxEdge = Math.max(maxEdge, w);
        }

        long lo = 0, hi = maxEdge, answer = -1;
        while (lo <= hi) {
            long mid = (lo + hi) >> 1;
            long dist = dijkstra(mid);

            if (dist <= budget) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static long dijkstra(long limit) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        dist[s] = 0;
        pq.offer(new long[]{s, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int v = (int) cur[0];
            long d = cur[1];

            if (d != dist[v]) continue;
            if (d > budget) return INF;
            if (v == e) return d;

            for (int[] nxt : graph.get(v)) {
                if (nxt[1] > limit) continue;
                long nd = d + nxt[1];
                if (nd < dist[nxt[0]]) {
                    dist[nxt[0]] = nd;
                    pq.offer(new long[]{nxt[0], nd});
                }
            }
        }
        
        return dist[e];
    }
}