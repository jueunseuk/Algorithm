import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] number = br.readLine().split(" ");
		
		int H = Integer.parseInt(number[0]);
		int M = Integer.parseInt(number[1]);
		
		if(M-45 < 0 && (0<H&&H<24)) {
			M = M-45+60;
			H--;
		}
		else if(M-45 < 0 && H==0) {
			M = M-45+60;
			H=23;
			
		}
		else if(M-45>=0) {
			M=M-45;
		}
		
		System.out.printf("%d %d", H, M);
		
		br.close();
	}

}
