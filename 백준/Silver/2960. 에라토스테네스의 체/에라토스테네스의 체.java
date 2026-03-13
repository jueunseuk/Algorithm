import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int current = 0;
		
		boolean[] arr = new boolean[N+1];
		Arrays.fill(arr, true);
		
		for (int i = 2; i <= N; i++) {
            if (arr[i]) {
                for (int j = i; j <= N; j += i) {
                    if (arr[j]) {
                        arr[j] = false;
                        cnt++;
                        if (cnt == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
		System.out.println(current);
	}

}
