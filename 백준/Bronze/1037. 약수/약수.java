import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}
		System.out.println(max*min);
	}
	
}
