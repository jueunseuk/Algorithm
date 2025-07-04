import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int row, col;
	static char[][] matrix;
	static boolean[][] visit;
	static boolean[][] result;
	
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        result = new boolean[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
        	char[] input = br.readLine().toCharArray();
        	matrix[i] = input;
        }
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == 'W' && !visit[i][j]) {
        			bfs(i, j);
        		}
        	}
        }
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(!result[i][j] && matrix[i][j] == '.') {
        			matrix[i][j] = 'P';
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		sb.append(matrix[i][j]);
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		result[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(!outOfRange(nx, ny) || matrix[nx][ny] == '#') continue;
				
                while (outOfRange(nx, ny) && matrix[nx][ny] == '+') {
                	int tx = nx + dx[delta];
                    int ty = ny + dy[delta];

                    if (!outOfRange(tx, ty)) break;
                    if (matrix[tx][ty] == '+') {
                        nx = tx; ny = ty;
                    } else if (matrix[tx][ty] == '.' || matrix[tx][ty] == 'W') {
                        nx = tx; ny = ty;
                        break;
                    } else {
                        break;
                    }
                }
                
                if (!visit[nx][ny] && matrix[nx][ny] != '#') {
                    visit[nx][ny] = true;
                    result[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
			}
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < row && ny < col;
	}
}