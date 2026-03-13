import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][]input = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int []request = new int[4];
			
			for(int j = 0; j < 4; j++) {
				request[j] = Integer.parseInt(st.nextToken());
			}
			
			//sum
			int sum = 0;
			
			for(int j = request[0]-1; j <= request[2]-1; j++) {
				for(int k = request[1]-1; k <= request[3]-1; k++) {
					sum += input[j][k];
				}
			}
			
			System.out.println(sum);
		}
	}

}
