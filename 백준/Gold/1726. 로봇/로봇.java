import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int row, col;
	static int matrix[][];
	static boolean visit[][][];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        visit = new boolean[row][col][4];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int x1 = Integer.parseInt(st.nextToken())-1;
        int y1 = Integer.parseInt(st.nextToken())-1;
        int d1 = Integer.parseInt(st.nextToken())-1;
        
        st = new StringTokenizer(br.readLine(), " ");
        int x2 = Integer.parseInt(st.nextToken())-1;
        int y2 = Integer.parseInt(st.nextToken())-1;
        int d2 = Integer.parseInt(st.nextToken())-1;
        
        bfs(x1, y1, d1, x2, y2, d2);
	}

	private static void bfs(int x1, int y1, int d1, int x2, int y2, int d2) {
		Queue<Section> q = new ArrayDeque<>();
		
		q.offer(new Section(x1, y1, d1, 0));
		visit[x1][y1][d1] = true;
		
		while(!q.isEmpty()) {
			Section poll = q.poll();
			
			if(poll.x == x2 && poll.y == y2 && poll.dir == d2) {
				System.out.println(poll.cnt);
			}
			
			// first. go straight for k
			for(int multi = 1; multi <= 3; multi++) {
				int nx = 0, ny = 0;
				
				switch(poll.dir) {
					case 0: {
						nx = poll.x;
						ny = poll.y + 1*multi;
						break;
					}
					case 1: {
						nx = poll.x;
						ny = poll.y - 1*multi;
						break;
					}
					case 2: {
						nx = poll.x + 1*multi;
						ny = poll.y;
						break;
					}
					case 3: {
						nx = poll.x - 1*multi;
						ny = poll.y;
						break;
					}
				}
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny][poll.dir]) {
					if(matrix[nx][ny] == 1) {
						break;
					}
					q.offer(new Section(nx, ny, poll.dir, poll.cnt+1));
					visit[nx][ny][poll.dir] = true;
				}
			}
			
			// second. turn right or left
			int nd1 = 0, nd2 = 0;
			switch(poll.dir) {
				case 0: {
					nd1 = 2; nd2 = 3; break;
				}
				case 1: {
					nd1 = 3; nd2 = 2; break;
				}
				case 2: {
					nd1 = 1; nd2 = 0; break;
				}
				case 3: {
					nd1 = 0; nd2 = 1; break;
				}
			}
			
			if(!visit[poll.x][poll.y][nd1]) {
				q.offer(new Section(poll.x, poll.y, nd1, poll.cnt+1));
				visit[poll.x][poll.y][nd1] = true;
			}
			
			if(!visit[poll.x][poll.y][nd2]) {
				q.offer(new Section(poll.x, poll.y, nd2, poll.cnt+1));
				visit[poll.x][poll.y][nd2] = true;
			}
		}
	}

	public static class Section {
		int x, y, dir, cnt;
		
		public Section(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
}