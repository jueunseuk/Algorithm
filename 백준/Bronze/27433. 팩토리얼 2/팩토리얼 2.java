import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        
        if(n <= 1) {
        	System.out.println(1);
        	return;
        }

        long r = 1;
        for(int i = 2; i <= n; i++) {
        	r *= i;
        }
        
        System.out.println(r);
	}
}