import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//입력도구는 Scanner/BufferedReader
		
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in)); // Scanner 클래스의 멤버 사용할 준비.
		
		String a = s.readLine();
		
		StringTokenizer tokens = new StringTokenizer(a, " ");
		
		int su1 = Integer.parseInt(tokens.nextToken());
		int su2 = Integer.parseInt(tokens.nextToken());
		
		
		System.out.println(su1+su2);
		//println(s.nextInt()+s.nextInt()); 동일한 결과.
		
		
	}

}
