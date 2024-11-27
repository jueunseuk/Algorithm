import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int down = Integer.parseInt(st.nextToken()) % 10;
            int up = Integer.parseInt(st.nextToken());

            if (down == 1) {
                sb.append(1).append("\n");
            } else if (down == 2) {
                if (up % 4 == 1) {
                    sb.append(2).append("\n");
                } else if (up % 4 == 2) {
                    sb.append(4).append("\n");
                } else if (up % 4 == 3) {
                    sb.append(8).append("\n");
                } else {
                    sb.append(6).append("\n");
                }
            } else if (down == 3) {
                if (up % 4 == 1) {
                    sb.append(3).append("\n");
                } else if (up % 4 == 2) {
                    sb.append(9).append("\n");
                } else if (up % 4 == 3) {
                    sb.append(7).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (down == 4) {
                if (up % 2 == 1) {
                    sb.append(4).append("\n");
                } else {
                    sb.append(6).append("\n");
                }
            } else if (down == 5) {
                sb.append(5).append("\n");
            } else if (down == 6) {
                sb.append(6).append("\n");
            } else if (down == 7) {
                if (up % 4 == 1) {
                    sb.append(7).append("\n");
                } else if (up % 4 == 2) {
                    sb.append(9).append("\n");
                } else if (up % 4 == 3) {
                    sb.append(3).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (down == 8) {
                if (up % 4 == 1) {
                    sb.append(8).append("\n");
                } else if (up % 4 == 2) {
                    sb.append(4).append("\n");
                } else if (up % 4 == 3) {
                    sb.append(2).append("\n");
                } else {
                    sb.append(6).append("\n");
                }
            } else if (down == 9) {
                if (up % 2 == 1) {
                    sb.append(9).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else {
                sb.append(10).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
