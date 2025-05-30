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
        
        int lan[] = new int[n];
        
        for(int i = 0; i < n; i++) {
        	lan[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(lan);
        
        long left = 1, right = lan[n-1], mid, result = 0;
        while(left <= right) {
        	int cnt = 0;
        	mid = (left+right) >> 1;
        	
        	for(int out : lan) {
        		cnt += out / mid;
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