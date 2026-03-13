import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] meetings = new int[N][2];
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < 2; j++) {
        		meetings[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 종료 시간을 기준으로 오름차순 정렬, 종료 시간이 같으면 시작 시간을 기준으로 오름차순 정렬
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        int count = 0;
        int endTime = 0;
        
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= endTime) {
                endTime = meetings[i][1];
                count++;
            }
        }
        
        System.out.println(count);
    }
}
