import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n = 10000;
	static boolean []prime = new boolean[n];
	static boolean []visit;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        makePrime();
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        System.out.println(sb.toString().trim());
	}


	private static void bfs(int int1, int int2) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[n];
		
		q.offer(new int[] {int1, 0});
		visit[int1] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == int2) {
				sb.append(poll[1]+"\n");
				return;
			}
			
			int dist = poll[1]+1;
			int curr = poll[0];
			int four = poll[0]%10;
			int three = (poll[0]/10)%10;
			int two = (poll[0]/100)%10;
			int one = poll[0]/1000;
			
			curr -= four;
			for(int delta = 0; delta <= 9; delta++) {
				if(prime[curr] && !visit[curr]) {
					q.offer(new int[] {curr, dist});
					visit[curr] = true;
				}
				curr++;
			}
			
			curr = poll[0];
			curr -= three*10;
			for(int delta = 0; delta <= 9; delta++) {
				if(prime[curr] && !visit[curr]) {
					q.offer(new int[] {curr, dist});
					visit[curr] = true;
				}
				curr += 10;
			}
			
			curr = poll[0];
			curr -= two*100;
			for(int delta = 0; delta <= 9; delta++) {
				if(prime[curr] && !visit[curr]) {
					q.offer(new int[] {curr, dist});
					visit[curr] = true;
				}
				curr += 100;
			}
			
			curr = poll[0];
			curr -= one*1000;
			curr += 1000;
			for(int delta = 0; delta < 9; delta++) {
				if(prime[curr] && !visit[curr]) {
					q.offer(new int[] {curr, dist});
					visit[curr] = true;
				}
				curr += 1000;
			}
		}
		
		sb.append("Impossible"+"\n");
	}

	private static void makePrime() {
		Arrays.fill(prime, true);
		
		prime[0] = prime[1] = false;
		
		for(int i = 2; i < Math.sqrt(n); i++) {
			if(prime[i]) {
				for(int j = i*i; j < n; j += i) {
					prime[j] = false;
				}
			}
		}
	}
}