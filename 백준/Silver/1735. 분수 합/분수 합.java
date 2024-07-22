import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int y1 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int son, par;
		
		// 공통 분모를 구합니다.
        int denominator = x2 * y2;
        // 분자를 구합니다.
        int numerator = x1 * y2 + y1 * x2;

        // 분자와 분모의 최대공약수를 구합니다.
        int gcd = GCD(numerator, denominator);

        // 기약 분수로 만들기 위해 분자와 분모를 최대공약수로 나눕니다.
        numerator /= gcd;
        denominator /= gcd;

        System.out.println(numerator + " " + denominator);
	}

	private static int GCD(int a, int b) {
		if(b==0) {
			return a;
		}
		return GCD(b, a%b);
	}
}
