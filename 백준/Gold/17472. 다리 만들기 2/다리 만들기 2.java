import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 10000000;
	
	static int row, col, islandCnt = 1, total = 0, cnt = 0;
	static int matrix[][];
	static boolean visit[][];
	static boolean useIsland[];
	
	static List<List<Edge>> list;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        		if(matrix[i][j] == 1) matrix[i][j] = -1;
        	}
        }
        
        // island indexing and island counting
        visit = new boolean[row][col];
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == -1 && !visit[i][j]) {
        			bfs(i, j);
        			islandCnt++;
        		}
        	}
        }
        islandCnt--;
        
        // calculate weight
        list = new ArrayList<>();
        for(int i = 0; i <= islandCnt; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 1; i <= islandCnt; i++) {
        	for(int j = i+1; j <= islandCnt; j++) {
        		int dist = calcDist(i, j);
        		
        		list.get(i).add(new Edge(j, dist));
        		list.get(j).add(new Edge(i, dist));
        	}
        }
        
        // get MST
        prim();
        
        // output
        System.out.println(cnt == islandCnt-1 ? total : -1);
	}
	
	private static void prim() {
		Queue<Edge> q = new PriorityQueue<>();
		useIsland = new boolean[islandCnt+1];
		
		q.addAll(list.get(1));
		useIsland[1] = true;
		
		while(!q.isEmpty()) {
			Edge poll = q.poll();
			
			if(useIsland[poll.node] || poll.w == INF) continue;
			
			total += poll.w;
			useIsland[poll.node] = true;
			cnt++;
			
			for(Edge out : list.get(poll.node)) {
				if(!useIsland[out.node]) {
					q.offer(out);
				}
			}
		}
	}

	private static int calcDist(int a, int b) {
	    int min = INF;

	    for (int x = 0; x < row; x++) {
	        for (int y = 0; y < col; y++) {
	            if (matrix[x][y] != a) continue;

	            for (int d = 0; d < 4; d++) {
	                int nx = x + dx[d];
	                int ny = y + dy[d];
	                int len = 0;

	                while(nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] == 0) {
	                    len++;
	                    nx += dx[d];
	                    ny += dy[d];
	                }

	                if(len >= 2 && nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] == b) {
	                    min = Math.min(min, len);
	                }
	            }
	        }
	    }
	    return min;
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[row][col];
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			matrix[poll[0]][poll[1]] = islandCnt;
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == -1) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
	}
	
	public static class Edge implements Comparable<Edge> {
		int node;
		int w;
		
		public Edge(int node, int w) {
			this.node = node;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}