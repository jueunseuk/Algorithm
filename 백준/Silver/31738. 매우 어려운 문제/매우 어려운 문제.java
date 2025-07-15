import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long n = Long.parseLong(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(n >= m) {
			System.out.println(0);
			return;
		}
		
		long res = 1;
        for (long i = 2; i <= n; i++) {
            res *= i;
            res %= m;
            if (res == 0) break;
        }
        
        System.out.println(res);
	}
}