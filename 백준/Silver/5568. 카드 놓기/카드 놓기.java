import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N, R;
    static String[] result;
    static String[] input;
    static Set<String> list;
    static boolean[] isSelected;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        
        input = new String[N];
        for(int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        
        isSelected = new boolean[N];
        result = new String[R];
        list = new HashSet<>();
        
        makePermutation(0);
        
        System.out.println(list.size());
    }

    private static void makePermutation(int depth) {
        if(depth == R) {
            StringBuilder str = new StringBuilder();
            for(int k = 0; k < R; k++) {
                str.append(result[k]);
            }
            list.add(str.toString());
            return;
        }
        for(int i = 0; i < N; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            result[depth] = input[i];
            makePermutation(depth + 1);
            isSelected[i] = false;
        }
    }
}
