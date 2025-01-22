import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String A = br.readLine();
        String B = br.readLine();

        Set<String> set = new HashSet<>();
        
        int sLength = S.length();
        int aLength = A.length();
        int bLength = B.length();
        
        for (int i = 0; i <= sLength - aLength; i++) {
            if (S.startsWith(A, i)) {
                for (int j = i; j <= sLength - bLength; j++) {
                    if (S.startsWith(B, j)) {
                        if (j + bLength >= i + aLength) {
                            set.add(S.substring(i, j + bLength));
                        }
                    }
                }
            }
        }

        System.out.println(set.size());
    }
}