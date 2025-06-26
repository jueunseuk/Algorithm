import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int row = 2, col;
    static long repeat;
    static char[][] matrix;
    static boolean[][] visit;
    static final long INF = (long) 1e18;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        repeat = Long.parseLong(st.nextToken());

        matrix = new char[row][col];
        visit = new boolean[row][col];
        for (int i = 0; i < row; i++) matrix[i] = br.readLine().toCharArray();

        if (matrix[0][0] == '#' && matrix[1][0] == '#') {
            System.out.println(-1);
            return;
        }
        if (matrix[0][col - 1] == '#' && matrix[1][col - 1] == '#') {
            System.out.println(-1);
            return;
        }

        long[][] base = new long[2][2];
        for (int i = 0; i < 2; i++) {
            long[] d = cost(i);
            base[i][0] = d[0];
            base[i][1] = d[1];
        }

        long[][] res = { {0, INF}, {INF, 0} };
        long k = repeat;
        while (k > 0) {
            if ((k & 1) == 1) res = mult(res, base);
            base = mult(base, base);
            k >>= 1;
        }

        long ans = INF;
        for (int s = 0; s < 2; s++) {
            if (matrix[s][0] == '#') continue;
            for (int e = 0; e < 2; e++) {
                if (matrix[e][col - 1] == '#') continue;
                long lane = res[s][e];
                if (lane >= INF) continue;
                long total = (long) col * repeat - 1 + lane;
                ans = Math.min(ans, total);
            }
        }
        System.out.println(ans >= INF ? -1 : ans);
    }

    static long[][] mult(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long v = INF;
                for (int k = 0; k < 2; k++) {
                    long a = A[i][k], b = B[k][j];
                    if (a >= INF || b >= INF) continue;
                    v = Math.min(v, a + b);
                }
                C[i][j] = v;
            }
        }
        return C;
    }

    static long[] cost(int start) {
        if (matrix[start][0] == '#') return new long[] {INF, INF};
        long[][] dist = new long[2][col];
        for (int i = 0; i < 2; i++) Arrays.fill(dist[i], INF);
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dist[start][0] = 0;
        dq.add(new int[] {start, 0});
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];
            long d = dist[r][c];
            if (c < col - 1 && matrix[r][c + 1] == '.' && dist[r][c + 1] > d) {
                dist[r][c + 1] = d;
                dq.addFirst(new int[] {r, c + 1});
            }
            int nr = 1 - r;
            if (matrix[nr][c] == '.' && dist[nr][c] > d + 1) {
                dist[nr][c] = d + 1;
                dq.addLast(new int[] {nr, c});
            }
        }
        return new long[] {dist[0][col - 1], dist[1][col - 1]};
    }
}
