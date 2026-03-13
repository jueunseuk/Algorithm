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
		 Double.parseDouble(su1);
		 Double.parseDouble(su2);
		 
		 System.out.println(Double.parseDouble(su1)/Double.parseDouble(su2));
		 
		 br.close();
	}

}
