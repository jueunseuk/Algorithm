import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        Set<Integer> seenStickers = new HashSet<>();
        int maxStickers = 0;
        int currentCount = 0;

        for (int i = 0; i < 2 * N; i++) {
            int sticker = Integer.parseInt(input[i]);
            if (seenStickers.contains(sticker)) {
                seenStickers.remove(sticker);
                currentCount--;
            } else {
                seenStickers.add(sticker);
                currentCount++;
                if (currentCount > maxStickers) {
                    maxStickers = currentCount;
                }
            }
        }

        System.out.println(maxStickers);
    }
}
