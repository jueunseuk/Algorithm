import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        long result = n;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
        	if(n % i == 0) {
        		while(n % i == 0) {
        			n /= i;
        		}
        		
        		result -= result/i;
        	}
        	
        }
        if(n > 1) {
        	result -= result/n;
        }
        
        System.out.println(result);
	}
}