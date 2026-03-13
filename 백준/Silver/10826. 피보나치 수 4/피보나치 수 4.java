import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	static BigInteger[] fibo = new BigInteger[10001];

	public static void main(String[] args) throws Exception {
		fibo();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(fibo[Integer.parseInt(br.readLine())]);
	}
	
	public static void fibo() {
		fibo[0] = new BigInteger("0");
		fibo[1] = new BigInteger("1");
		
		for(int i = 2; i < 10001; i++) {
			fibo[i] = fibo[i-1].add(fibo[i-2]);
		}
	}

}
