import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int rst[] = new int[N];
        
        for(int i = 0; i < N; i++) {
        	String[] number = br.readLine().split(" ");
        	int A = Integer.parseInt(number[0]);
        	int B = Integer.parseInt(number[1]);
        	rst[i] = A+B;
        }
        
        for(int i = 0; i < N; i++)
        System.out.println(rst[i]);
        
        
        br.close();
    }

}
