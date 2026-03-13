import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main { // 풀이 1

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N : 총 배달해야 할 kg
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N + 1];
        Arrays.fill(dp, N + 1);
        dp[0] = 0;
        
        for (int i = 3; i <= 5; i+=2) { 
            for (int j = i; j <= N; j++)
            	dp[j] = Math.min(dp[j], dp[j - i] + 1);
        }
        
        if (dp[N] == N + 1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
        

    }
}
