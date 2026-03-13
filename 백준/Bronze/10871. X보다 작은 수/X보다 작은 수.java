import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
	    int[] input = new int[N];
	    for(int i = 0; i < N; i++)
	    input[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <N; i++) {
        	if(input[i] < X) {
        		System.out.print(input[i]);
        		if(i < N-1) System.out.print(" ");
        	}
        }
        
        br.close();
    }

}
