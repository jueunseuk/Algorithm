import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int []dx = {1, -1, 2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int subin = Integer.parseInt(st.nextToken());
		int dongsang = Integer.parseInt(st.nextToken());
		
		int result = bfs(subin, dongsang);
		
		System.out.println(result);
	}

	private static int bfs(int subin, int dongsang) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean isVisited[] = new boolean[100001];
		queue.add(new int[] {subin, 0});
		isVisited[subin] = true;
		
		while(!queue.isEmpty()) {
			int current[] = queue.poll();
			int currentPos = current[0];
			int distance = current[1];
			
			if(currentPos == dongsang) {
				return distance;
			}
			
			for (int i = 0; i < 3; i++) {
                int newPos;
                if (i == 0 || i == 1) {
                    newPos = currentPos + dx[i];
                } else {
                    newPos = currentPos * dx[i];
                }

                if (newPos >= 0 && newPos <= 100000 && !isVisited[newPos]) {
                    isVisited[newPos] = true;
                    queue.add(new int[]{newPos, distance + 1});
                }
            }
			
		}
		
		return 0;
		
	}

}
