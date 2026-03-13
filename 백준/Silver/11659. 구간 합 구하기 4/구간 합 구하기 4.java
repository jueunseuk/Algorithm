import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N, M 입력
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        
        // 숫자 배열 입력 및 누적 합 배열 생성
        int[] intArr = new int[N + 1];
        String[] strArr = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            intArr[i] = intArr[i - 1] + Integer.parseInt(strArr[i - 1]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            String[] range = br.readLine().split(" ");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            
            int sum = intArr[end] - intArr[start - 1];
            sb.append(sum).append('\n');
        }
        
        // 결과 출력
        System.out.print(sb);
        
        br.close();
    }
}
