import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	 public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum[] = new int[n];
		sum[0] = input[0];
		
		for(int i = 1; i < n; i++) {
			sum[i] = sum[i-1]+input[i];
		}
		
		long answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0 , 1);
		
		for(int i = 0; i < n; i++) {
			answer += map.getOrDefault(sum[i]-k, 0);
			map.put(sum[i], map.getOrDefault(sum[i], 0)+1);
		}
		
		System.out.println(answer);
	}
}