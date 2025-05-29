import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int a, b, c;
	static boolean[][][] visit;
	
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        bfs();
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(int out : list) {
        	sb.append(out+" ");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[a+1][b+1][c+1];
		
		visit[0][0][c] = true;
		q.offer(new int[] {0, 0, c});
		
		list.add(c);
		
		while (!q.isEmpty()) {
		    int[] poll = q.poll();
		    
		    if(poll[0] == 0 && !list.contains(poll[2])) {
		    	list.add(poll[2]);
		    }

		    /* A → B */
		    if (poll[0] + poll[1] <= b) {
		        if (!visit[0][poll[1] + poll[0]][poll[2]]) {
		            q.offer(new int[]{0, poll[1] + poll[0], poll[2]});
		            visit[0][poll[1] + poll[0]][poll[2]] = true;
		        }
		    } else {
		        if (poll[1] < b && !visit[poll[0] + poll[1] - b][b][poll[2]]) {
		            q.offer(new int[]{poll[0] + poll[1] - b, b, poll[2]});
		            visit[poll[0] + poll[1] - b][b][poll[2]] = true;
		        }
		    }

		    /* A → C */
		    if (poll[0] + poll[2] <= c) {
		        if (!visit[0][poll[1]][poll[0] + poll[2]]) {
		            q.offer(new int[]{0, poll[1], poll[0] + poll[2]});
		            visit[0][poll[1]][poll[0] + poll[2]] = true;
		        }
		    } else {
		        if (poll[2] < c && !visit[poll[0] + poll[2] - c][poll[1]][c]) {
		            q.offer(new int[]{poll[0] + poll[2] - c, poll[1], c});
		            visit[poll[0] + poll[2] - c][poll[1]][c] = true;
		        }
		    }

		    /* B → A */
		    if (poll[0] + poll[1] <= a) {
		        if (!visit[poll[0] + poll[1]][0][poll[2]]) {
		            q.offer(new int[]{poll[0] + poll[1], 0, poll[2]});
		            visit[poll[0] + poll[1]][0][poll[2]] = true;
		        }
		    } else {
		        if (poll[0] < a && !visit[a][poll[0] + poll[1] - a][poll[2]]) {
		            q.offer(new int[]{a, poll[0] + poll[1] - a, poll[2]});
		            visit[a][poll[0] + poll[1] - a][poll[2]] = true;
		        }
		    }

		    /* B → C */
		    if (poll[1] + poll[2] <= c) {
		        if (!visit[poll[0]][0][poll[1] + poll[2]]) {
		            q.offer(new int[]{poll[0], 0, poll[1] + poll[2]});
		            visit[poll[0]][0][poll[1] + poll[2]] = true;
		        }
		    } else {
		        if (poll[2] < c && !visit[poll[0]][poll[1] + poll[2] - c][c]) {
		            q.offer(new int[]{poll[0], poll[1] + poll[2] - c, c});
		            visit[poll[0]][poll[1] + poll[2] - c][c] = true;
		        }
		    }

		    /* C → A */
		    if (poll[0] + poll[2] <= a) {
		        if (!visit[poll[0] + poll[2]][poll[1]][0]) {
		            q.offer(new int[]{poll[0] + poll[2], poll[1], 0});
		            visit[poll[0] + poll[2]][poll[1]][0] = true;
		        }
		    } else {
		        if (poll[0] < a && !visit[a][poll[1]][poll[0] + poll[2] - a]) {
		            q.offer(new int[]{a, poll[1], poll[0] + poll[2] - a});
		            visit[a][poll[1]][poll[0] + poll[2] - a] = true;
		        }
		    }

		    /* C → B */
		    if (poll[1] + poll[2] <= b) {
		        if (!visit[poll[0]][poll[1] + poll[2]][0]) {
		            q.offer(new int[]{poll[0], poll[1] + poll[2], 0});
		            visit[poll[0]][poll[1] + poll[2]][0] = true;
		        }
		    } else {
		        if (poll[1] < b && !visit[poll[0]][b][poll[1] + poll[2] - b]) {
		            q.offer(new int[]{poll[0], b, poll[1] + poll[2] - b});
		            visit[poll[0]][b][poll[1] + poll[2] - b] = true;
		        }
		    }
		}
	}
}