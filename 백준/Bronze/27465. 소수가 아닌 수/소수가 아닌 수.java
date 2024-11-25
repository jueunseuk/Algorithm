import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N==1) {
			System.out.println(4);
		}
		else if(N==2) {
			System.out.println(4);
		}
		else if(N%2==0) {
			System.out.println(N);
		}
		else if(N%2==1) {
			System.out.println(N+1);
		}
	}

}
