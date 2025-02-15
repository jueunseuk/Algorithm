import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 배열 돌리기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 행 개수
        int M = Integer.parseInt(input[1]); // 열 개수
        int R = Integer.parseInt(input[2]); // 회전 수

        int[][] arr = new int[N][M];

        // 원본 배열 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        int layers = Math.min(N, M) / 2;

        for (int layer = 0; layer < layers; layer++) {
            Queue<Integer> queue = new LinkedList<>();
            int startX = layer;
            int startY = layer;
            int endX = N - 1 - layer;
            int endY = M - 1 - layer;

            // 윗줄
            for (int j = startY; j < endY; j++) queue.add(arr[startX][j]);
            // 오른쪽줄
            for (int i = startX; i < endX; i++) queue.add(arr[i][endY]);
            // 아랫줄
            for (int j = endY; j > startY; j--) queue.add(arr[endX][j]);
            // 왼쪽줄
            for (int i = endX; i > startX; i--) queue.add(arr[i][startY]);

            int length = queue.size();
            int rotation = R % length;

            for (int i = 0; i < rotation; i++) queue.add(queue.poll());
                
            

            // 다시 배열에 삽입
            // 윗줄
            for (int j = startY; j < endY; j++) arr[startX][j] = queue.poll();
            // 오른쪽줄
            for (int i = startX; i < endX; i++) arr[i][endY] = queue.poll();
            // 아랫줄
            for (int j = endY; j > startY; j--) arr[endX][j] = queue.poll();
            // 왼쪽줄
            for (int i = endX; i > startX; i--) arr[i][startY] = queue.poll();
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);

        br.close();
    }
}
