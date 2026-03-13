import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		
		int a = Integer.parseInt(number);
		
		if((a%4==0&&a%100!=0) || a%400==0) System.out.println("1");
		else System.out.println("0");
		br.close();
	}

}
