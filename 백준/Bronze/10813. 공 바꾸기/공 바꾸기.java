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
        int a, b;
        
        int []result = new int[N];
        for(int i = 0; i < N; i++) result[i] = i+1;
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            
            int temp = result[a];
            result[a] = result[b];
            result[b] = temp;
        }
        //출력
        for(int i = 0; i < N; i++) {
        	System.out.print(result[i]);
        	if(i < N-1) System.out.print(" ");
        }
        br.close();
    }
}
