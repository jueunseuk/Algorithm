import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(input);
        
        Set<Integer> twoSums = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                twoSums.add(input[i] + input[j]);
            }
        }
        
        for (int k = N - 1; k >= 0; k--) {
            for (int i = 0; i < N; i++) {
                if (twoSums.contains(input[k] - input[i])) {
                    System.out.println(input[k]);
                    return;
                }
            }
        }
    }
}
