import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Map<String, Object>> members = new ArrayList<>();
        
        for(int i = 0; i < N;i ++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int age = Integer.parseInt(st.nextToken());
        	String name = st.nextToken();
        	
        	Map<String, Object> mem = new HashMap<>();
        	
        	mem.put("age", age);
        	mem.put("name", name);
        	
        	members.add(mem);
        	
        }
        
        members.sort(new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> m1, Map<String, Object> m2) {
                // m1과 m2는 비교할 두 Map 객체
                return Integer.compare((int) m1.get("age"), (int) m2.get("age"));
            }
        });
        
        for (Map<String, Object> member : members) {
        	System.out.println(member.get("age") + " " + member.get("name"));
        }
	}

}
