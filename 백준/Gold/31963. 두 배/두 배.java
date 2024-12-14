import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        long[] arr = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int cnt = 0;
        arr[0] = Long.parseLong(st.nextToken());
        for(int i = 1; i < n; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        	while(arr[i] < arr[i-1]) {
        		arr[i] *= 2;
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
	}

}
