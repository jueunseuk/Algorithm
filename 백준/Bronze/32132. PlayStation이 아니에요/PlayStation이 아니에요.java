import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String result[] = br.readLine().split("");
		
		for(int i = 0; i < result.length-2; i++) {
			if(result[i].equals("P")){
				if(result[i+1].equals("S")) {
					int j = i+2;
					while(j < result.length) {
						if(result[j].equals("4") || result[j].equals("5")) {
							result[j] = "";
							j++;
						} else {
							break;
						}
					}
				}
			}
		}
	
		for(String out : result)
		System.out.print(out);
	}

}
