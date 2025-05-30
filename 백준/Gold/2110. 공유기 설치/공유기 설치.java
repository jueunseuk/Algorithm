import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] input = new int[n];
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(input);
        
        int left = 1, right = input[n-1]-input[0], gap, result = 0;
        while(left <= right) {
        	gap = (left + right) >> 1;
        	
	        int routers = 1;
	        int last = input[0];
	
	        for (int i = 1; i < n; i++) {
	            if (input[i] - last >= gap) {
	                routers++;
	                last = input[i];
	            }
	        }
        	
	        if (routers >= k) {
                result = gap;
                left = gap + 1;
            } else {
                right = gap - 1;
            }
        }
        
        System.out.println(result);
	}
}