import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int input[] = new int[n];
		int avg[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		int tempSum = input[0]+input[n-1];
		for(int i = 1; i < n-1; i++) {
			avg[i] = (tempSum + input[i]);
		}
		
		int maxSub = Integer.MIN_VALUE;
		
		for(int i = 1; i < n-1; i++) {
			if(input[i]*3 >= avg[i]) {
				maxSub = Math.max(Math.abs((input[0]+input[i]+input[i+1]) - input[i]*3), maxSub);
			} else {
				maxSub = Math.max(Math.abs((input[i-1]+input[i]+input[n-1]) - input[i]*3), maxSub);
			}
		}
		
		System.out.println(maxSub);
	}

}
