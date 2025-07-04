import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        
        long two = 0, five = 0;
        
        two = calc(n, 2) - calc(n-m, 2) - calc(m, 2);
        five = calc(n, 5) - calc(n-m, 5) - calc(m, 5);

        System.out.println(Math.min(two, five));
	}

	private static long calc(long m, long param) {
		long result = 0;
		while(m >= param) {
			result += m/param;
			m /= param;
		}
		return result;
	}
}
