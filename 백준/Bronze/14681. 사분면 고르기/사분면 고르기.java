import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String xInput = br.readLine();
		String yInput = br.readLine();
		
		int x = Integer.parseInt(xInput);
		int y = Integer.parseInt(yInput);
		
		if(x > 0 && y > 0) System.out.println("1");
		else if(x < 0 && y > 0) System.out.println("2");
		else if(x < 0 && y < 0) System.out.println("3");
		else System.out.println("4");
			
			
		br.close();
	}

}
