import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int size = 100000;
	
	static int n, k, a, b;
	static boolean visit[];
	
	static int dx[];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        dx = new int[] {1, -1, a, b, -a, -b};
        
        bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[size+1];
		
		q.offer(new int[] {n, 0});
		visit[n] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == k) {
				System.out.println(poll[1]);
				return;
			}
			
			for(int delta = 0; delta < 6; delta++) {
				int nx = poll[0] + dx[delta];
				
				if(nx >= 0 && nx <= size && !visit[nx]) {
					q.offer(new int[] {nx, poll[1] + 1});
					visit[nx] = true;
				}
				
				if(delta == 2 || delta == 3) {
					nx = poll[0] * dx[delta];
					
					if(nx <= size && !visit[nx]) {
						q.offer(new int[] {nx, poll[1] + 1});
						visit[nx] = true;
					}
				}
			}
		}
	}
}