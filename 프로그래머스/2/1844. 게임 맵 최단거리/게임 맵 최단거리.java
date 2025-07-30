import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        que.offer(new int[] { 0, 0, 1 });
        visited[0][0] = true;

        int[] tmp; int r; int c; int dist; int nr; int nc;

        while (!que.isEmpty()) {
            tmp = que.poll();
            r = tmp[0];
            c = tmp[1];
            dist = tmp[2];

            if (r == n - 1 && c == m - 1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                nr = r + dir[d][0];
                nc = c + dir[d][1];

                if (!isValid(nr, nc, n, m) || visited[nr][nc] || maps[nr][nc] == 0) {
                    continue;
                }

                visited[nr][nc] = true;
                que.offer(new int[] { nr, nc, dist + 1 });
            }
        }

        return -1;
    }

    static boolean isValid(int r, int c, int n, int m) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
