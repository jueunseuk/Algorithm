import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] number = br.readLine().split(" ");
		
		int a = Integer.parseInt(number[0]);
		int b = Integer.parseInt(number[1]);
		
		if(a > b) System.out.println(">");
		else if(a < b) System.out.println("<");
		else System.out.println("==");
		
		br.close();
	}

}
