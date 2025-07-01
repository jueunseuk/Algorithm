import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1000000000;
	
	static int n, m, s, e, money;
	static List<List<int[]>> list = new ArrayList<>();
	static int cost[][];
	
	static Comparator<int[]> comparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[2] == o2[2]) return o1[1] - o2[1];
			return o1[2] - o2[2];
		}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		money = Integer.parseInt(st.nextToken());
		
		cost = new int[n+1][2];
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			cost[i][0] = INF;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new int[] {end, c});
			list.get(end).add(new int[] {start, c});
		}
		
		dijkstra();
	}

	private static void dijkstra() {
		Queue<int[]> q = new PriorityQueue<>(comparator);
		
		q.offer(new int[] {s, 0, 0});
		cost[s][0] = 0;
		cost[s][1] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == e) {
				System.out.println(poll[2]);
				return;
			}
			
			if(poll[1] > cost[poll[0]][0]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = out[1] + poll[1];
				
				if(nc > money) continue;
				
				if(cost[out[0]][0] > nc) {
					cost[out[0]][0] = nc;
					cost[out[0]][1] = Math.max(poll[2], out[1]);
					q.offer(new int[] {out[0], nc, cost[out[0]][1]});
				}
			}
		}
		
		System.out.println(-1);
	}
}