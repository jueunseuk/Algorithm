import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int n1 = Integer.parseInt(st.nextToken());
        	int n2 = Integer.parseInt(st.nextToken());
        	
        	if(n1 == 0 && n2 == 0) {
        		break;
        	}
        	
        	if(n1 > n2) {
        		sb.append("Yes"+"\n");
        	} else {
        		sb.append("No"+"\n");
        	}
        }

        System.out.println(sb.toString().trim());
	}
}