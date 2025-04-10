import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		br.close();
		
		int[] dp = new int[50001];
		dp[0] = 0;
		dp[1] = 1;
		
		int min;
		for(int i = 2; i < 50001; i++) {
			min = Integer.MAX_VALUE;
			
			for(int j = 1; j*j <= i; j++) {
				min = Math.min(min, dp[i-j*j]);
			}
			
			dp[i] = min+1;
		}
		
		System.out.println(dp[n]);
	}
}