import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int cnt = 0, left = 0, right = 1;
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				if(arr[i]+arr[j] > l) {
					break;
				}
				
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}

}
