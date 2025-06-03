import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int n, m, max = 0;
	static int total = 0;
	static List<List<Edge>> list = new ArrayList<>();
	static boolean visit[];

	public static void main(String[] args) throws Exception {
        Reader rd = new Reader();
        
        n = rd.nextInt();
        m = rd.nextInt();
        
        visit = new boolean[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	int start = rd.nextInt();
        	int end = rd.nextInt();
        	int c = rd.nextInt();
        	
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
	
	static class Reader {
	    private final int SIZE = 1 << 13;
	    private byte[] buffer = new byte[SIZE];
	    private int index, size;
	    int nextInt() throws Exception {
	        int lis = 0;
	        byte c;
	        boolean isMinus = false;
	        while ((c = read()) <= 32);
	        if (c == 45) { c = read(); isMinus = true; }
	        do lis = (lis << 3) + (lis << 1) + (c & 15);
	        while (isnumber(c = read()));
	        return isMinus ? ~lis + 1 : lis;
	    }
	    String readLine() throws Exception{
	        StringBuilder sb = new StringBuilder();
	        byte c;
	        c = read();
	        do sb.appendCodePoint(c);
	        while ((c = read())!=10);
	        return sb.toString();
	    }
	    String nextString() throws Exception {
	        StringBuilder sb = new StringBuilder();
	        byte c;
	        while ((c = read()) <= 32);
	        do sb.appendCodePoint(c);
	        while (isAlphabet(c = read())||isnumber(c));
	        return sb.toString();
	    }
	    String nextWord() throws Exception {
	        StringBuilder sb = new StringBuilder();
	        byte c;
	        while ((c = read()) <= 32);
	        do sb.appendCodePoint(c);
	        while ((c = read())!=32&&c!=10);
	        return sb.toString();
	    }

	    char nextChar() throws Exception {
	        char ch = ' ';
	        byte c;
	        while ((c = read()) <= 32);
	        do ch = (char)c;
	        while (isAlphabet(c = read()));
	        return ch;
	    }

	    long nextLong() throws Exception {
	        long lis = 0;
	        byte c;
	        boolean isMinus = false;
	        while ((c = read()) <= 32);
	        if (c == 45) { c = read(); isMinus = true; }
	        do lis = (lis << 3) + (lis << 1) + (c & 15);
	        while (isnumber(c = read()));
	        return isMinus ? ~lis + 1 : lis;
	    }

	    double nextDouble() throws Exception {
	        double lis = 0, div = 1;
	        byte c;
	        boolean isMinus = false;
	        while ((c = read()) <= 32);
	        if (c == 45) { c = read(); isMinus = true; }
	        else if (c == 46) { c = read(); }
	        do lis = (lis * 10) + (c & 15);
	        while (isnumber(c = read()));
	        if (c == 46) { while (isnumber(c = read())){ lis += (c - 48) / (div *= 10); }}
	        return isMinus ? -lis : lis;
	    }

	    private boolean isAlphabet(byte c){
	        return (64 < c && c < 91) || (96 < c && c < 123);
	    }

	    private boolean isnumber(byte c) {
	        return 47 < c && c < 58;
	    }

	    private byte read() throws Exception {
	        if (index == size) {
	            size = System.in.read(buffer, index = 0, SIZE);
	            if (size < 0) buffer[0] = -1;
	        }
	        return buffer[index++];
	    }
	}
}