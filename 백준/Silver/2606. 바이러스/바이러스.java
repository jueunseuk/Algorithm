import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adjList;
	static int N, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 정점 개수
		int M = Integer.parseInt(br.readLine()); // 간선 개수
		
		adjList = new ArrayList[N + 1];
		
		for(int i = 1; i<= N; i++) adjList[i] = new ArrayList<>(); // 이중 리스트 만들기
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		bfs();
		System.out.println(cnt);
		
		br.close();
		
	}//main
	
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean isVisited[] = new boolean[N+1];
		
		int current = 1;
		q.add(current);
		isVisited[current] = true;
		
		while(!q.isEmpty()) {
			current = q.poll();
			
			for (int next : adjList[current]) {
	            if (!isVisited[next]) {
	            	isVisited[next] = true;
	                q.add(next);
	                cnt++; //추출할때마다 증가
	            }
	        }
		}
	}//bfs
}//class
