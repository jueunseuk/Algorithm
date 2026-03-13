import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String num1 = br.readLine();
		 StringTokenizer tokens = new StringTokenizer(num1, " ");
		 
		 String su1 = tokens.nextToken();
		 String su2 = tokens.nextToken();
		 String su3 = tokens.nextToken();
		 int a = Integer.parseInt(su1);
		 int b = Integer.parseInt(su2);
		 int c = Integer.parseInt(su3);
		 
		 System.out.println((a+b)%c);
		 System.out.println((a%c+b%c)%c);
		 System.out.println((a*b)%c);
		 System.out.println(((a%c)*(b%c))%c);

		 br.close();
	}

}
