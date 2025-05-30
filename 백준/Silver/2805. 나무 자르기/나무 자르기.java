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
        long k = Integer.parseInt(st.nextToken());
        
        long lan[] = new long[n];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	lan[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(lan);
        
        long left = 1, right = lan[n-1], mid, result = 0;
        while(left <= right) {
        	long cnt = 0;
        	mid = (left+right) >> 1;
        	
        	for(long out : lan) {
        		cnt += Math.max(0, out-mid);
        	}
        	
        	if(cnt >= k) {
        		result = mid;
        		left = mid+1;
        	} else {
        		right = mid-1;
        	}
        }
        
        System.out.println(result);
	}
}