import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int[][] matrix;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static class Group {
        int stoneCount;
        Set<Integer> liberties;
        
        public Group() {
            stoneCount = 0;
            liberties = new HashSet<>();
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        matrix = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean[][] visited = new boolean[row][col];
        List<Group> groups = new ArrayList<>();
        Set<Integer> candidateSet = new HashSet<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 2 && !visited[i][j]) {
                    Group group = new Group();
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cx = cur[0], cy = cur[1];
                        group.stoneCount++;
                        
                        for (int d = 0; d < 4; d++) {
                            int nx = cx + dx[d];
                            int ny = cy + dy[d];
                            if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                            
                            if (matrix[nx][ny] == 0) {
                                group.liberties.add(nx * col + ny);
                            } else if (matrix[nx][ny] == 2 && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    
                    if (group.liberties.size() <= 2) {
                        groups.add(group);
                        candidateSet.addAll(group.liberties);
                    }
                }
            }
        }
        
        List<Integer> candidates = new ArrayList<>(candidateSet);
        int maxCaptured = 0;
        
        int candSize = candidates.size();
        for (int i = 0; i < candSize; i++) {
            for (int j = i + 1; j < candSize; j++) {
                int stone1 = candidates.get(i);
                int stone2 = candidates.get(j);
                int captured = 0;
                
                for (Group g : groups) {
                    if (g.liberties.size() == 1) {
                        if (g.liberties.contains(stone1) || g.liberties.contains(stone2)) {
                            captured += g.stoneCount;
                        }
                    } else if (g.liberties.size() == 2) {
                        if (g.liberties.contains(stone1) && g.liberties.contains(stone2)) {
                            captured += g.stoneCount;
                        }
                    }
                }
                maxCaptured = Math.max(maxCaptured, captured);
            }
        }
        
        for (int stone : candidates) {
            int captured = 0;
            for (Group g : groups) {
                if (g.liberties.size() == 1 && g.liberties.contains(stone)) {
                    captured += g.stoneCount;
                }
            }
            maxCaptured = Math.max(maxCaptured, captured);
        }
        
        System.out.println(maxCaptured);
    }
}
