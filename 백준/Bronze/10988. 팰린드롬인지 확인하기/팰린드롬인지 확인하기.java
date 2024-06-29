import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int N = str.length;
        int result = 1;
        
        out:
        for(int i = 0; i < N / 2; i++) {
        		if(!str[i].equals(str[N - i - 1])) {
        			result -= 1;
        			break out;
        	}
        }
        
        System.out.println(result);
    }
}
