import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] number = new int[9][9];
        int max = Integer.MIN_VALUE;
        int[] idx = new int[2];
        
        for(int i = 0; i < 9; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < 9; j++) {
        		number[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		if(max < number[i][j]) {
        			max=number[i][j];
        			idx[0] = i+1;
        			idx[1] = j+1;
        		}
        	}
        }
        System.out.println(max);
        System.out.println(idx[0]+" "+idx[1]);
        
        br.close();
    }

}
