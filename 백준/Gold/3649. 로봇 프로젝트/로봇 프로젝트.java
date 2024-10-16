import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        while((input = br.readLine()) != null) {
            long CENTI_TO_NANO = 10_000_000L;
            
            // 입력 처리
            int originTarget = Integer.parseInt(input);
            long target = originTarget * CENTI_TO_NANO;
            
            int lego = Integer.parseInt(br.readLine());
            long[] arr = new long[lego];
            
            for(int i = 0; i < lego; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            
            // 정렬
            Arrays.sort(arr);
            
            int left = 0, right = lego - 1;
            boolean found = false;
            
            // 이진 탐색을 통한 두 수의 합 비교
            while(left < right) {
                long sum = arr[left] + arr[right];
                
                if(sum > target) {
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    System.out.println("yes " + arr[left] + " " + arr[right]);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("danger");
            }
        }
    }
}
