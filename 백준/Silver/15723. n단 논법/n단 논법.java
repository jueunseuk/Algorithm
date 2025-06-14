import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int size = 26;
	static int n, q;
	static boolean result[][];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        result = new boolean[size][size];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	int start = st.nextToken().charAt(0) - 'a';
        	st.nextToken();
        	int end = st.nextToken().charAt(0) - 'a';
        	
        	result[start][end] = true;
        }
        
        for(int k = 0; k < size; k++) {
        	for(int i = 0; i < size; i++) {
        		for(int j = 0; j < size; j++) {
        			result[i][j] |= result[i][k] && result[k][j];
        		}
        	}
        }
        
        q = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = st.nextToken().charAt(0) - 'a';
        	st.nextToken();
        	int end = st.nextToken().charAt(0) - 'a';
        	
        	sb.append(result[start][end] ? "T" : "F").append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}