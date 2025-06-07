import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int row, col, result;
	static boolean flag = true;
	static boolean visit[][];
	static int matrix[][];
	static int cnt[][];
	
	static List<int[]> candidate = new ArrayList<>();
	
	static final int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
	static final int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        cnt = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	char[] input = br.readLine().toCharArray();
        	
        	for(int j = 0; j < col; j++) {
        		if(input[j] == '.') {
        			matrix[i][j] = 0;
        		} else {
        			matrix[i][j] = input[j] - '0';
        		}
        	}
        }
        
        for(int i = 1; i < row-1; i++) {
        	for(int j = 1; j < col-1; j++) {
        		if(matrix[i][j] != 0) {
        			checking(i, j);
        			if(cnt[i][j] >= matrix[i][j]) candidate.add(new int[] {i, j});
        		}
        	}
        }
        
        bfs();
        
        System.out.println(result);
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[row][col];
		
		for(int[] out : candidate) {
			visit[out[0]][out[1]] = true;
			q.offer(out);
		}
		
		while (!q.isEmpty()) {
	        int size = q.size();

	        for (int s = 0; s < size; s++) {
	            int[] cur = q.poll();
	            int x = cur[0], y = cur[1];
	            matrix[x][y] = 0;

	            for (int d = 0; d < 8; d++) {
	                int nx = x + dx[d], ny = y + dy[d];
	                if (matrix[nx][ny] == 0) continue;

	                if (++cnt[nx][ny] >= matrix[nx][ny] && !visit[nx][ny]) {
	                    q.offer(new int[]{nx, ny});
	                    visit[nx][ny] = true;
	                }
	            }
	            
	        }
	        result++;
	    }
	}

	private static void checking(int x, int y) {
		for(int delta = 0; delta < 8; delta++) {
			int nx = x + dx[delta];
			int ny = y + dy[delta];
			
			if(matrix[nx][ny] == 0) cnt[x][y]++;
		}
	}
}