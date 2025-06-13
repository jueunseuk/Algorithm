import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, length;
	static List<List<Integer>> list = new ArrayList<>();
	static int top[];
	static Map<String, Integer> map = new HashMap<>();
	static Map<Integer, String> map2 = new HashMap<>();
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());
        
        int max = 2*m + 1;
        top = new int[max];
        for(int i = 0; i < max; i++) {
        	list.add(new ArrayList<>());
        }
        
        int idx = 0;
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	String start = st.nextToken();
        	String end = st.nextToken();
        	
        	if(!map.containsKey(start)) {
        		map.put(start, idx);
        		map2.put(idx++, start);
        	}
        	if(!map.containsKey(end)) {
        		map.put(end, idx);
        		map2.put(idx++, end);
        	}
        	
        	list.get(map.get(start)).add(map.get(end));
        	top[map.get(end)]++;
        }
        
        length = idx;
        
        topologicalSort();
        
        for(int i = 0; i < length; i++) {
        	if(top[i] != 0) {
        		System.out.println(-1);
        		return;
        	}
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void topologicalSort() {
		Queue<Node> q = new PriorityQueue<>();
		
		for(int i = 0 ; i < length; i++) {
			if(top[i] == 0) {
				q.offer(new Node(i, map2.get(i), 0));
			}
		}
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			sb.append(poll.name+"\n");
			
			for(int out : list.get(poll.node)) {
				if(--top[out] == 0) {
					q.offer(new Node(out, map2.get(out), poll.level+1));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int node;
		String name;
		int level;
		
		public Node(int node, String name, int level) {
			this.node = node;
			this.name = name;
			this.level = level;
		}

		@Override
		public int compareTo(Node o) {
			if(this.level == o.level) return this.name.compareTo(o.name);
			return this.level - o.level;
		}
	}
}