import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n1 = Integer.parseInt(br.readLine());
			if(n1 == 0) break;
			
			int n2 = n1*2;
			boolean[] arr = new boolean[n2+1];
			Arrays.fill(arr, true);
			
			arr[1]=false;
			for(int i = 2; i*i <= n2; i++) {
				if(arr[i])
				for(int j = i*i; j <= n2; j+=i) {
					arr[j] = false;
				}
				
			}
			
			int  cnt = 0;
			
			for(int i = n1+1; i <= n2; i++) {
				if(arr[i]) cnt++;
			}
			
			System.out.println(cnt);
		}
		
		
	}

}
