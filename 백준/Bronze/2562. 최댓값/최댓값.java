import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int idx = 0;
        
        int[] input = new int[9];
	    for(int i = 0; i < 9; i++)
	    input[i] = Integer.parseInt(br.readLine());
        
	    for(int i = 0; i < 9; i++) {
	    	if(max < input[i]) {
	    		max = input[i];
	    		idx = i+1;
	    	}
	    }
        
        System.out.println(max);
        System.out.println(idx);
        
        br.close();
    }

}
