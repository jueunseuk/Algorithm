import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final long INF = Long.MAX_VALUE;
	
	static int n, m, k;
	static List<List<int[]>> list = new ArrayList<>();
	static long cost[];
	
	static Queue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        cost = new long[n+1];
        Arrays.fill(cost, INF);
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.get(end).add(new int[] {start, c});
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < k; i++) {
        	int temp = Integer.parseInt(st.nextToken());
        	q.offer(new long[] {temp, 0});
        	cost[temp] = 0;
        }
        
        dijkstra();
        
        int num = 0;
        long max = 0;
        for(int i = 1; i <= n; i++) {
        	if(cost[i] > max) {
        		max = cost[i];
        		num = i;
        	}
        }
        
        System.out.println(num);
        System.out.println(max);
	}

	private static void dijkstra() {
		while(!q.isEmpty()) {
			long[] poll = q.poll();
			
			if(poll[1] > cost[(int) poll[0]]) continue;
			
			for(int[] out : list.get((int) poll[0])) {
				long temp = poll[1] + out[1];
				if(cost[out[0]] > temp) {
					cost[out[0]] = temp;
					q.offer(new long[] {out[0], temp});
				}
			}
		}
	}
}