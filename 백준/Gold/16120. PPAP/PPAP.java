import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : input) {
            stack.push(c);
            
            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 'P' &&
                    stack.get(size - 3) == 'P' &&
                    stack.get(size - 2) == 'A' &&
                    stack.get(size - 1) == 'P') {
                    
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push('P');
                }
            }
        }
        
        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
