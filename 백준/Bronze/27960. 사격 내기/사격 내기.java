import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int scoreA = Integer.parseInt(st.nextToken());
        int scoreB = Integer.parseInt(st.nextToken());
        int scoreC = 0;
        
        int tle[] = new int[11];
        tle[1] = 1;
        int resultA[] = new int[11];
        int resultB[] = new int[11];
        int resultC[] = new int[11];
        
        for(int i = 2; i <= 10; i++) tle[i] =2*tle[i-1];
        
        for(int i = 10; i >= 1; i--) {
        	if(scoreA > tle[i]) {
        		scoreA -= tle[i];
        		resultA[i] = 1;
        	}
        	else if(scoreA == tle[i]) {
        		resultA[i] = 1;
        		break;
        	}
        	else {
        		continue;
        	}
        }
        
        for(int i = 10; i >= 1; i--) {
        	if(scoreB > tle[i]) {
        		scoreB -= tle[i];
        		resultB[i] = 1;
        	}
        	else if(scoreB == tle[i]) {
        		resultB[i] = 1;
        		break;
        	}
        	else {
        		continue;
        	}
        }
        
        for(int i = 1; i <= 10; i++) {
        	if(resultA[i]+resultB[i] == 1) {
        		resultC[i] = 1;
        	}
        }
        
        for(int i = 1; i <= 10; i++) {
        	if(resultC[i] == 1) {
        		scoreC += tle[i];
        	}
        }
        
        System.out.println(scoreC);
	}

}
