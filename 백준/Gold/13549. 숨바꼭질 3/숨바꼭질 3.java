import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int dongsang = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs(subin, dongsang));
    }

    private static int bfs(int subin, int dongsang) {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] isVisited = new boolean[100001];
        deque.add(new int[]{subin, 0});
        isVisited[subin] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int currentPos = current[0];
            int distance = current[1];

            if (currentPos == dongsang) {
                return distance;
            }

            // 순간이동 처리 (0초 소요)
            int newPos = currentPos * 2;
            if (newPos <= 100000 && !isVisited[newPos]) {
                isVisited[newPos] = true;
                deque.addFirst(new int[]{newPos, distance});
            }

            // 걷기 처리 (1초 소요)
            newPos = currentPos - 1;
            if (newPos >= 0 && !isVisited[newPos]) {
                isVisited[newPos] = true;
                deque.addLast(new int[]{newPos, distance + 1});
            }

            newPos = currentPos + 1;
            if (newPos <= 100000 && !isVisited[newPos]) {
                isVisited[newPos] = true;
                deque.addLast(new int[]{newPos, distance + 1});
            }
        }
        return -1;
    }
}
