import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        	Arrays.fill(result[i], INF);
        	result[i][i] = 0;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	result[start][end] = 1;
        	result[end][start] = 1;
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
        		}
        	}
        }
        
        int[] currResult = {0, 0, INF};
        for(int i = 1; i < n; i++) {
        	for(int j = i + 1; j <= n; j++) {
        		int sum = 0;
        		
        		for(int k = 1; k <= n; k++) {
        			sum += Math.min(result[i][k], result[j][k]) << 1;
        		}
        		
        		if(currResult[2] > sum) {
        			currResult[0] = i;
        			currResult[1] = j;
        			currResult[2] = sum;
        		}
        	}
        }

        System.out.println(currResult[0]+" "+currResult[1]+" "+currResult[2]);
	}
}