import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean possible = true;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int[][] curr = new int[r2][c2];
            for (int a = 0; a < r2; a++) {
                st = new StringTokenizer(br.readLine());
                for (int b = 0; b < c2; b++) {
                    curr[a][b] = Integer.parseInt(st.nextToken());
                }
            }

            if (arr[0].length != r2) {
                possible = false;
                break;
            }

            int r1 = arr.length;
            int k = arr[0].length;
            int c1 = c2;

            int[][] multi = new int[r1][c1];

            for (int a = 0; a < r1; a++) {
                for (int b = 0; b < c1; b++) {
                    long val = 0;
                    for (int c = 0; c < k; c++) {
                        val += (long) arr[a][c] * curr[c][b];
                        val %= MOD;
                    }
                    multi[a][b] = (int) val;
                }
            }

            arr = multi;
        }

        if (!possible) {
            System.out.println(-1);
            return;
        }

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
                sum %= MOD;
            }
        }

        System.out.println(sum);
    }
}
