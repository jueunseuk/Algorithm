import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //바구니 개수
        int M = Integer.parseInt(st.nextToken()); //공의 입력
        
        int []result = new int[N];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int ball = Integer.parseInt(st.nextToken());
                
            for(int j = start; j <= end; j++) {
                    result[j] = ball;
            }
        }
        //출력
        for(int i = 0; i < N; i++) {
        	System.out.print(result[i]);
        	if(i < N-1) System.out.print(" ");
        }
        br.close();
    }

}
