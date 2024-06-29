import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < A; i++){
			System.out.println(i+1);
			
		}
	}
}
