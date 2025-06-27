import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[] prime = new boolean[10001];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        preprocess();
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	int input = Integer.parseInt(br.readLine());
        	
        	int a = input/2;
        	int b = input/2;
        	
        	while(a > 0 && b < 10001) {
        		if(prime[a] && prime[b]) {
        			sb.append(a+" "+b).append("\n");
        			break;
        		}
        		a--;
        		b++;
        	}
        }

        System.out.println(sb.toString().trim());
	}

	private static void preprocess() {
		Arrays.fill(prime, true);
		
		prime[0] = false;
		prime[1] = false;
		
		for(int i = 2; i < Math.sqrt(10001); i++) {
			for(int j = i*i; j < 10001; j += i) {
				if(prime[j]) {
					prime[j] = false;
				}
			}
		}
	}
}