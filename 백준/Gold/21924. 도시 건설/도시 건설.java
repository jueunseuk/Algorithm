import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static long total = 0, origin = 0;
	static List<Edge> list = new ArrayList<>();
	static int par[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine() ," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        par = new int[n+1];
        for(int i = 1; i <= n; i++) {
        	par[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.add(new Edge(start, end, c));
        	
        	origin += c;
        }
        
        Collections.sort(list);
        
        int cnt = 0;
        for(Edge out : list) {
        	if(find(out.s) != find(out.e)) {
        		union(out.s, out.e);
        		total += out.w;
        		if(++cnt == n-1) break;
        	}
        }
        
        if(cnt < n-1) {
        	System.out.println(-1);
        	return;
        }
        
        System.out.println(origin-total);
	}
	
	public static int find(int x) {
		if(par[x] != x) {
			par[x] = find(par[x]);
		}
		return par[x];
	}
	
	public static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		
		if(rx != ry) {
			par[rx] = ry;
		}
	}

	public static class Edge implements Comparable<Edge> {
		int s, e, w;

		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}