import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    
    static Set<String> set;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!isCycle(str)) {
                set.add(str);
            }
        }
        
        System.out.println(set.size());
    }

    private static boolean isCycle(String str) {
        int len = str.length();
        String rotated = str;

        for (int i = 0; i < len; i++) {
            rotated = rotated.substring(1) + rotated.charAt(0);
            if (set.contains(rotated)) {
                return true;
            }
        }
        
        return false;
    }
}
