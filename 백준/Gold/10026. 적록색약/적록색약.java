import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static char[][] matrix;
    static char[][] blindMatrix;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new char[N][N];
        blindMatrix = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
            	// 우선 일반 배열을 입력 받은 뒤 일반 배열의 R 값은 전부 G로 치환해서 색맹 배열에 할당
            	// 일반 배열을 입력 받음과 동시에 색맹 배열 복사하는 과정
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'R') {
                    blindMatrix[i][j] = 'G';
                }
                else {
                    blindMatrix[i][j] = matrix[i][j];
                }
            }
        }

        int normalCount = 0;
        int blindCount = 0;

        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    bfs(matrix, i, j);
                    normalCount++;
                }
            }
        }

        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    bfs(blindMatrix, i, j);
                    blindCount++;
                }
            }
        }

        System.out.println(normalCount+" "+blindCount);
    }

    private static void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        isVisited[i][j] = true;
        char color = board[i][j];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int k = 0; k < 4; k++) {
                int newX = currentX + dx[k];
                int newY = currentY + dy[k];
                
                // 새로운 위치가 배열 이내의 범위인지 체크하고
                // 방문한적 없는지 체크하고
                // 현재 찾고 있는 색상과 일치하는지 확인해서 큐에 추가
                if (newX >= 0 && newX < N && newY >= 0 && newY < N && !isVisited[newX][newY] && board[newX][newY] == color) {
                    isVisited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }
}
