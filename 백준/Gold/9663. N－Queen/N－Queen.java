import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] cols;
    static int cnt = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        cols = new int[N]; // 퀸 배치
        
        // 첫번째 행부터 백트래킹 시작
        backtracking(0);
        
        System.out.println(cnt);
    }
    
    public static void backtracking(int row) {
        if (row == N) { // N-1행까지만 재귀
            cnt++;
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (isPossible(row, col)) {
                cols[row] = col; // (row, col)에 퀸 배치
                backtracking(row + 1);
            }
        }
    }
    
    public static boolean isPossible(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있거나, 대각선에 위치한다면
            if (cols[i] == col || Math.abs(cols[i] - col) == row - i) return false;
        }
        return true;
    }
}
