package A3bfs;
//    이차원배열의최단거리 : 게임 맵 최단거리 - 프로그래머스
//    비노드형식의 거리문제 : 숨바꼭질 - 백준
import java.util.*;
class Solution {
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;
    static int n, m;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        n = maps.length + 1;
        m = maps[0].length + 1;
        visited = new boolean[n][m];
        int answer = bfs(1, 1, maps);
        return answer;
    }

    static int bfs(int x, int y, int[][] maps) {
        q.add(new int[]{x, y, 1});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] here = q.poll();
            int r = here[0];
            int c = here[1];
            int d = here[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int dist = d + 1;
                if (nr >= 1 && nc >= 1 && nr < n && nc < m && maps[nr - 1][nc - 1] == 1) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc, dist});
                        if (nr == n - 1 && nc == m - 1) {
                            return dist;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

