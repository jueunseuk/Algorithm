import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int nimSum = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int stones = Integer.parseInt(st.nextToken());
            nimSum ^= stones;
        }
        
        if (nimSum != 0) {
            System.out.println("koosaga");
        } else {
            System.out.println("cubelover");
        }
    }
}