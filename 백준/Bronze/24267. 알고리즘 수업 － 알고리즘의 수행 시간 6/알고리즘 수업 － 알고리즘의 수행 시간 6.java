import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long in = Long.parseLong(br.readLine());
        System.out.println(in*(in-1)*(in-2)/6);
        System.out.println(3);
	}
}