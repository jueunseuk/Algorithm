import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long n[] = new long[2];
		n[0] = Long.parseLong(st.nextToken());
		n[1] = Long.parseLong(st.nextToken());
		System.out.println(Math.abs(n[1]-n[0]));
	}

}
