import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int input[][] = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < 2; j++) {
				input[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[1] == p2[1]) {
                	return Integer.compare(p1[0], p2[0]);
                }
                else return Integer.compare(p1[1], p2[1]);
            }
        });
		
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(input[i][0]).append(" ").append(input[i][1]).append("\n");
        }

        System.out.print(sb.toString());
	
	}
}
