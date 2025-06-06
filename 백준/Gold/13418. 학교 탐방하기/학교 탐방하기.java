import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static long min = 0, max = 0;;
	static List<List<int[]>> list = new ArrayList<>();
	static boolean visit[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine() ," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i <= m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = 1-Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, c});
        	list.get(end).add(new int[] {start, c});
        }
        
        primMin();
        primMax();
        
        System.out.println(max-min);
	}

	private static void primMin() {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		visit = new boolean[n+1];
		
		q.addAll(list.get(0));
		visit[0] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(visit[poll[0]]) continue;
			
			visit[poll[0]] = true;
			min += poll[1];
			
			if(++cnt == n) break;
			
			for(int[] out : list.get(poll[0])) {
				if(!visit[out[0]]) {
					q.offer(out);
				}
			}
		}
		
		min *= min;
	}
	
	private static void primMax() {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		visit = new boolean[n+1];
		
		q.addAll(list.get(0));
		visit[0] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(visit[poll[0]]) continue;
			
			visit[poll[0]] = true;
			max += poll[1];
			
			if(++cnt == n) break;
			
			for(int[] out : list.get(poll[0])) {
				if(!visit[out[0]]) {
					q.offer(out);
				}
			}
		}
		
		max *= max;
	}
}