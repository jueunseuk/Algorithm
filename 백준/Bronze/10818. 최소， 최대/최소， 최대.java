import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0; i < N; i++)
	    input[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
        	if(max < input[i]) max = input[i];
        	if(min > input[i]) min = input[i];
        }
        
        System.out.println(min+" "+max);
        
        br.close();
    }

}
