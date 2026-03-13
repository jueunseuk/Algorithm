import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        int r = 31;
        int M = 1234567891;
        
        long hash = 0;
        long rPower = 1;
        
        for (int i = 0; i < L; i++) {
            int charValue = str.charAt(i) - 'a' + 1;
            hash = (hash + charValue * rPower) % M;
            rPower = (rPower * r) % M;
        }
        
        System.out.println(hash);
    }
}
