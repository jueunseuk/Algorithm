import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int []input = new int[n];
		boolean[] exist = new boolean[100001];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		long cnt = 0;
		
		int start = 0, end = 0;
		while(start < n) {
		    while(end < n && !exist[input[end]]) {
		        exist[input[end]] = true;
		        end++;
		    }
		    
		    cnt += (end - start);
		    
		    exist[input[start]] = false;
		    start++;
		}
		
		System.out.println(cnt);
	}
}