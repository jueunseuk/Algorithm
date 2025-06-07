import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static final int INF = 100000000;
	
	static int n, cnt = 0, total = 0, origin = 0;
	static List<List<int[]>> list = new ArrayList<>();
	static int matrix[][];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
        	Arrays.fill(matrix[i], INF);
        }
        
        for(int i = 0; i < n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++) {
        	char[] input = br.readLine().toCharArray();
        	
        	for(int j = 0; j < n; j++) {
        		if(input[j] == '0') {
        			matrix[i][j] = 0;
        		} else if(input[j] > 95) {
        			matrix[i][j] = Math.min(matrix[i][j], input[j] - 'a' + 1);
        			if(i != j) {
        				list.get(i).add(new int[] {j, matrix[i][j]});
        				list.get(j).add(new int[] {i, matrix[i][j]});
        			}
        		} else {
        			matrix[i][j] = Math.min(matrix[i][j], input[j] - 'A' + 27);
        			if(i != j) {
        				list.get(i).add(new int[] {j, matrix[i][j]});
        				list.get(j).add(new int[] {i, matrix[i][j]});
        			}
        		}
        		
        		origin += matrix[i][j];
        	}
        }
        
        prim(0);

        System.out.println(cnt == n-1 ? origin-total : -1);
	}

	private static void prim(int i) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		visit = new boolean[n];
		
		q.addAll(list.get(i));
		visit[i] = true;
		
		cnt = 0;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(visit[poll[0]]) continue;
			
			total += poll[1];
			visit[poll[0]] = true;
			
			if(++cnt == n-1) {
				break;
			}
			
			for(int[] out : list.get(poll[0])) {
				if(!visit[out[0]]) {
					q.offer(out);
				}
			}
		}
	}
}