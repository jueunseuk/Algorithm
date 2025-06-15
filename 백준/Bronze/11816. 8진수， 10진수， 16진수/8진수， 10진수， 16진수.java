import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder input = new StringBuilder(br.readLine());
        
        if(input.charAt(0) == '0') {
        	if(input.charAt(1) == 'x') {
        		input.delete(0, 2);
        		System.out.println(Integer.parseInt(input.toString(), 16));
        	} else {
        		input.delete(0, 1);
        		System.out.println(Integer.parseInt(input.toString(), 8));
        	}
        } else {
        	System.out.println(input);
        }
	}
}