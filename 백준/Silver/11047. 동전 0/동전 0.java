import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int coinCnt = 0;
		
		int[] value = new int[N];
		for(int i = 0; i < N; i++) value[i] = Integer.parseInt(br.readLine());
		
			for(int i = N-1; i >= 0; i--) {
				if(K >= value[i]) {
					coinCnt += K/value[i];
					K %= value[i];
				}
			}
		
		
		System.out.println(coinCnt);
		
		br.close();
	}

}
