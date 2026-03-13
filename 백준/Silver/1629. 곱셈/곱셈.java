import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(modularExponentiation(A, B, C));
    }

    public static long modularExponentiation(long base, long exponent, long modulus) {
        if (exponent == 0) return 1;
        long half = modularExponentiation(base, exponent / 2, modulus);
        long halfSquared = (half * half) % modulus;
        if (exponent % 2 != 0) {
            halfSquared = (halfSquared * base) % modulus;
        }
        return halfSquared;
    }
}
