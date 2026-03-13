import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] num;
	static int whiteCnt, blueCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		num = new int[N][N];
		//배열 입력 받기
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		div(0, 0, N);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
		
		br.close();
	}//main
	
	
	private static void div(int x, int y, int N) {
		int sum = 0; //sum 으로 그룹 확인
		
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				sum += num[i][j];
			}
		}
		
		if(sum == 0) whiteCnt++;
		else if(sum == N*N) blueCnt++;
		else {
			div(x, y, N/2);
			div(x, y+N/2, N/2);
			div(x+N/2, y, N/2);
			div(x+N/2, y+N/2, N/2);
		}
	}//div
}
