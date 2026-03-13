import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().split(" ");
        
        int H = Integer.parseInt(number[0]);
        int M = Integer.parseInt(number[1]);
        
        int C = Integer.parseInt(br.readLine());
        
        H += (M + C) / 60; // 시간 추가
        M = (M + C) % 60; // 분 계산
        
        if (H >= 24) { // 24시간을 초과할 경우
            H %= 24;
        }
        
        System.out.printf("%d %d", H, M);
        
        br.close();
    }

}
