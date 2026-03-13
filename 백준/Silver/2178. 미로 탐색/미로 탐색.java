import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //maze
	
	static boolean[][] isVisited;
	static int field[][];
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			
		field = new int[N][M];
		isVisited = new boolean[N][M]; // initialize to false
			
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		System.out.println(bfs());
		
		
		br.close();
	}//main
	
	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		
		isVisited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(field[nx][ny] == 1 && !isVisited[nx][ny]) {
						queue.add(new int[] {nx, ny});
						isVisited[nx][ny] = true;
						field[nx][ny] = field[x][y] + 1;
					}
				}
			}
		}
		return field[N-1][M-1];
	}//bfs
}//class