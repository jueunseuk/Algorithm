import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] number = br.readLine().split(" ");
		
		int a = Integer.parseInt(number[0]);
		int b = Integer.parseInt(number[1]);
		int c = Integer.parseInt(number[2]);
		
		if(a == b && b == c) {
			System.out.println("1"+a+"000");
		}
		else if(a != b && b != c && c != a) {
			System.out.println(Math.max(a, Math.max(b, c))+"00");
		}
		else {
			if(a==b)
				System.out.println("1"+a+"00");
			else if(a==c)
				System.out.println("1"+a+"00");
			else if(b==c)
				System.out.println("1"+b+"00");
		}
		
		br.close();
	}

}
