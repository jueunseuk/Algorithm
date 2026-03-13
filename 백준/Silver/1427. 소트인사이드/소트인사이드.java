import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []input = br.readLine().split("");
		Arrays.sort(input, Collections.reverseOrder());
		for(int i = 0 ; i < input.length; i++) {
			System.out.print(input[i]);
		}
	}
}
