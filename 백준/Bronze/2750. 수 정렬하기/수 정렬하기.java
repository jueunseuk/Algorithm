import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> l = new ArrayList<>();
        
        int N = Integer.parseInt(br.readLine());
        
        //배열 입력
        for(int i = 0; i < N; i++) l.add(Integer.parseInt(br.readLine()));
        
        for(int i = 1; i < N; i++) {
        	int temp = l.get(i);
        	int j = i-1;
        	
        	while(j >= 0 && temp < l.get(j)) {
        		l.set(j+1, l.get(j));
        		j--;
        	}	
        	
        	l.set(j+1, temp);
        }
        br.close();
        
        //입력 확인
        for (int num : l) {
            System.out.println(num);
        }
    }
}
