import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, max = 0;
	static int total = 0;
	static List<List<Edge>> list = new ArrayList<>();
	static boolean visit[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visit = new boolean[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new Edge(end, c));
        	list.get(end).add(new Edge(start, c));
        }
        
        prim();
        
        System.out.println(total-max);
	}

	private static void prim() {
		Queue<Edge>	q = new PriorityQueue<>();
		
		q.addAll(list.get(1));
		visit[1] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			Edge poll = q.poll();
			
			if(visit[poll.node]) {
				continue;
			}
			
			visit[poll.node] = true;
			total += poll.w;
			max = Math.max(max, poll.w);
			
			if(cnt++ == n-1) {
				break;
			}
			
			for(Edge out : list.get(poll.node)) {
				if(!visit[out.node]) {
					q.offer(out);
				}
			}
		}
	}

	static class Edge implements Comparable<Edge>{
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