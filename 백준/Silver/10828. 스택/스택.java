import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();
		
		String[] order = new String[2];
		for(int i = 0; i < N; i++) {
			order = br.readLine().split(" ");
			
			switch(order[0]) {
			case "push" : {
				stack.push(order[1]);
				break;
			}
			case "pop" : {
				System.out.println(stack.isEmpty() ? -1 : stack.pop());
				break;
			}
			case "size" : {
				System.out.println(stack.size());
				break;
			}
			case "empty" : {
				System.out.println(stack.isEmpty() ? 1 : 0);
				break;
			}
			case "top" : {
				System.out.println(stack.isEmpty() ? -1 : stack.peek());
				break;
			}
			}
			
		}
	}

}
