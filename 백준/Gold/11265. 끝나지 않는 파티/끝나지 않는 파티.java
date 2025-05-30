import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] result;
	
	static final int INF = 1000000000;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        result = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 1; j <= n; j++) {
        		result[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int require = Integer.parseInt(st.nextToken());
        	
        	if(result[start][end] <= require) {
        		sb.append("Enjoy other party"+"\n");
        	} else {
        		sb.append("Stay here"+"\n");
        	}
        }
        
        System.out.println(sb.toString().trim());
	}
}