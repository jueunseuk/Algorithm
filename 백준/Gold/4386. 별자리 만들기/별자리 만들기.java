import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static double total;
	static List<List<Edge>> list = new ArrayList<>();
	static boolean visit[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        visit = new boolean[n+1];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	list.add(new ArrayList<>());
        }
        
        double save[][] = new double[n+1][2];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	save[i][0] = Double.parseDouble(st.nextToken()); 
        	save[i][1] = Double.parseDouble(st.nextToken()); 
        }
        
        for(int i = 0; i < n; i++) {
        	for(int j = i+1; j < n; j++) {
        		double dist = calc(save[i][0], save[i][1], save[j][0], save[j][1]);
        		list.get(i).add(new Edge(j, dist));
        		list.get(j).add(new Edge(i, dist));
        	}
        }
        
        prim();
        
        System.out.printf("%.5f", total);
	}
	
	private static void prim() {
		Queue<Edge> q = new PriorityQueue<>();
		
		q.addAll(list.get(0));
		visit[0] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			Edge poll = q.poll();
			
			if(visit[poll.node]) continue;
			
			total += poll.w;
			visit[poll.node] = true;
			
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

	public static double calc(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}

	public static class Edge implements Comparable<Edge> {
		int node;
		double w;
		
		public Edge(int node, double w) {
			this.node = node;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
}