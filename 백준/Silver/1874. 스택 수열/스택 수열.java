import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int next = 1;
        boolean possible = true;

        for (int num : target) {
            while (next <= num) {
                stack.push(next++);
                sb.append('+').append('\n');
            }

            if (stack.peek() != num) {
                possible = false;
                break;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}