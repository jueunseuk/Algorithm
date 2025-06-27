import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true) {
        	int n = Integer.parseInt(br.readLine());
	        
	        if(n == 0) {
	        	break;
	        } else if(n == 1) {
	        	sb.append(0+"\n");
	        	continue;
	        }
	        
	        int origin = n;
	        int result = n;
	        
	        for(int i = 2; i*i <= origin; i++) {
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
	        
	        sb.append(result+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}