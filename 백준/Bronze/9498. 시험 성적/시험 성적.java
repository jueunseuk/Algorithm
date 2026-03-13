import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		
		int a = Integer.parseInt(number);
		
		if(a >= 90) System.out.println("A");
		else if(a >= 80) System.out.println("B");
		else if(a >= 70) System.out.println("C");
		else if(a >= 60) System.out.println("D");
		else System.out.println("F");
		
		br.close();
	}

}
