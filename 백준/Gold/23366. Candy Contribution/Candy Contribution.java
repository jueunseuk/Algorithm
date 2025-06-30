import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, s, t, init;
	static List<List<int[]>> list = new ArrayList<>();
	static long[] cost;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        init = Integer.parseInt(st.nextToken());
        
        cost = new long[n+1];
        Arrays.fill(cost, -1);
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = 100 - Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, c});
        	list.get(end).add(new int[] {start, c});
        }
        
        dijkstra();
	}

	private static void dijkstra() {
		Queue<Node> q = new PriorityQueue<>();
		
		q.offer(new Node(s, init));
		cost[s] = init;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.v == t) {
				System.out.println(poll.candy);
				break;
			}
			
			if(poll.candy < cost[poll.v]) continue;
			
			for (int[] e : list.get(poll.v)) {
	            long next = (poll.candy * e[1]) / 100;
	            if (next > cost[e[0]]) {
	                cost[e[0]] = next;
	                q.add(new Node(e[0], next));
	            }
	        }
		}
	}
	
	static class Node implements Comparable<Node> {
		int v;
		long candy;
		
		public Node(int v, long candy) {
			this.v = v;
			this.candy = candy;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(o.candy, this.candy);
		}
	}
}