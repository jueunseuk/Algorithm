import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < n; i++) {
        	q.offer(Integer.parseInt(br.readLine()));
        }
        
        for(int i = 0; i < t; i++) {
        	if(q.peek() < centi) {
        		System.out.println("YES");
        		System.out.println(i);
        		return;
        	}
        	if(q.peek() == 1) {
        		System.out.println("NO");
        		System.out.println(1);
        		return;
        	}
        	
        	q.offer(q.poll() >> 1);
        }
        
        if(q.peek() < centi) {
        	System.out.println("YES");
        	System.out.println(t);
        } else {
        	System.out.println("NO");
        	System.out.println(q.peek());
        }
    }
}
