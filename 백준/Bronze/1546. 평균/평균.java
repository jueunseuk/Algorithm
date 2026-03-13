import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double max = Integer.MIN_VALUE;
		
		double[] score = new double[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if(max < score[i]) max = score[i];
		}
		
		double[] score2 = new double[N];
		double sum = 0;
		for(int i = 0; i < N; i++) {
			score2[i] = score[i]*100/max;
			sum += score2[i];
		}
		
		System.out.println(sum/N);
	}
}
