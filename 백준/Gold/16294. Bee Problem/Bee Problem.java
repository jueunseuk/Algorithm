import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int row, col, k;
    static String[][] matrix;
    static boolean[][] visit;
    
    static int[] dx = {1, 1, -1, -1, 0, 0};
    static int[] dy = {1, -1, 1, -1, 2, -2};
    
    static StringBuilder result = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken())*2;
        
        matrix = new String[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	if(i % 2 == 0) {
        		for(int j = 0; j < col; j++) {
        			if(j % 2 == 0) {
        				matrix[i][j] = st.nextToken();
        			} else {
        				matrix[i][j] = " ";
        			}
        		}
        	} else {
        		for(int j = 0; j < col; j++) {
        			if(j % 2 == 1) {
        				matrix[i][j] = st.nextToken();
        			} else {
        				matrix[i][j] = " ";
        			}
        		}
        	}
        }
        
        if (k == 0) {
            System.out.println(0);
            return;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
    			if(!visit[i][j] && matrix[i][j].equals(".")) {
    				list.add(dfs(i, j));
    			}
        	}
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = 0;
        int i;
        for(i = 0; i < list.size(); i++) {
        	sum += list.get(i);
        	
        	if(sum >= k) {
        		break;
        	}
        }
        
        System.out.println(i+1);
        
	}

	public static int dfs(int i, int j) {
		visit[i][j] = true;
		int depth = 1;
		
		for(int delta = 0; delta < 6; delta++) {
			int nx = i + dx[delta];
			int ny = j + dy[delta];
			
			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny].equals(".")) {
				depth += dfs(nx, ny);
			}
		}
		
		return depth;
	}
}