import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int size = 3;
	static char[][] matrix;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			matrix = new char[size][size];
			visit = new boolean[size][size];
			visit[1][1] = true;
			
			for(int i = 0; i < size; i++) {
				matrix[i] = br.readLine().toCharArray();
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			int compare[] = new int[cnt];
			
			for(int i = 0; i < cnt; i++) {
				compare[i] = Integer.parseInt(st.nextToken());
			}
			
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(!visit[i][j] && matrix[i][j] == 'O') {
						int length = search(i, j);
						if(length > 0) list.add(length);
					}
				}
			}
			
			Collections.sort(list);
			
			if(list.size() != cnt) {
				sb.append(0+"\n");
				continue;
			}
			
			boolean flag = true;
			for(int i = 0; i < cnt; i++) {
				if(compare[i] != list.get(i)) {
					flag = false;
					break;
				}
			}
			
			sb.append(flag ? 1 : 0).append("\n");
		}

		System.out.println(sb.toString().trim());
	}

	private static int search(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		visit[i][j] = true;
		
		q.offer(new int[] {i, j});
		
		int length = 1;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < size && ny < size && !visit[nx][ny] && matrix[nx][ny] == 'O') {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					length++;
				}
			}
		}
		
		return length;
	}
}