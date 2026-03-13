import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] number;
	static boolean[] isSelected;
	static int S, target, cnt = 0;
	static List<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
		
		String[] input = br.readLine().split(" ");
		number = new int[S];
		for(int i = 0; i < S; i++) number[i] = Integer.parseInt(input[i]);
		
		isSelected = new boolean[S];
		
		makeSubset(0,0);
		
		if(target == 0) cnt--;
		
		System.out.println(cnt);
		
		br.close();
	}//main

	private static void makeSubset(int depth, int sum) {
		if(depth == S) {
			if(sum == target) cnt++;
			return;
		}
		makeSubset(depth+1, sum);
		makeSubset(depth+1, sum+number[depth]);
	}//makeSubset

}
