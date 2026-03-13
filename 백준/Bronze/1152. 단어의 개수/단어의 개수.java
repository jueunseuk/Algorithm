import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<String> list = new ArrayList<>();
		int i = 0;
		while(st.hasMoreTokens()) {
			list.add(st.nextToken());
			i++;
		}
		
		System.out.println(i);
	}

}
