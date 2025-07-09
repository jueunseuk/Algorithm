import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int [][] box;
	static int[] dx = new int[] {1, -1, 0, 0}; // 위아래로 이동
	static int[] dy = new int[] {0, 0, 1, -1}; // 좌우로 이동
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Queue<int[]> queue = new ArrayDeque<>(); // LinkedList 사용 가능
		
		box = new int[N][M];
		for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < M; j++) {
        		box[i][j] = Integer.parseInt(st.nextToken());
        		if(box[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
        	}
        }//for
		
		int days = bfs(queue);
		
		if(checkAllRipe()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
		br.close();
	}//main

	private static int bfs(Queue<int[]> queue) {
		int days = -1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                
                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
			days++;
		}//while
		
		return days;
	}//bfs
	
	private static boolean checkAllRipe() {
		for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    return false;
                }
            }
        }
		return true;
	}
	
}
