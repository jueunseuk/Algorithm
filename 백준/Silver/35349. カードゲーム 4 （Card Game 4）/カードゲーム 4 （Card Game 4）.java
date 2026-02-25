import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	int input = Integer.parseInt(st.nextToken());
        	if(input % 2 == 1) {
        		pq.offer(input);
        	}
        }
        
        if(pq.size() < k) {
        	System.out.println(0);
        } else {
        	long sum = 0;
        	for(int i = 0; i < k; i++) {
        		sum += pq.poll();
        	}
        	System.out.println(sum);
        }
	}
}