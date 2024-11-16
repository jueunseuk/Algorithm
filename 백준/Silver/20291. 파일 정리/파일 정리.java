import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < size; i++) {
			String input = br.readLine().split("\\.")[1];
			
			map.put(input, map.getOrDefault(input, 0) + 1);
		}
		
		List<String> list = new ArrayList<>(map.keySet());
		
		Collections.sort(list);
		
		for(String out : list) {
			System.out.println(out+" "+map.get(out));
		}
	}

}
