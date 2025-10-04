import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(String[] maps) {

        // 1. 초기 세팅
        int n = maps.length;
        int m = maps[0].length();

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        boolean[][] graph = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = maps[i].charAt(j);

                switch (ch) {
                    case 'S':
                        start[0] = i;
                        start[1] = j;
                        break;
                    case 'L':
                        lever[0] = i;
                        lever[1] = j;
                        break;
                    case 'E':
                        exit[0] = i;
                        exit[1] = j;
                }

                if (ch != 'X') {
                    graph[i][j] = true;
                }
            }
        }

        // 2. 로직
        int ans = 0;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] { start[0], start[1], 0 });

        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;

        out: while (!que.isEmpty()) {
            int[] tmp = que.poll();

            int r = tmp[0];
            int c = tmp[1];
            int cnt = tmp[2];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isValid(nr, nc, n, m) || !graph[nr][nc] || visited[nr][nc])
                    continue;

                if (nr == lever[0] && nc == lever[1]) {
                    ans = cnt + 1;
                    break out;
                }

                visited[nr][nc] = true;
                que.offer(new int[] { nr, nc, cnt + 1 });
            }
        }

        if (ans == 0) {
            return -1;
        }

        que = new ArrayDeque<>();
        que.offer(new int[] { lever[0], lever[1], ans });

        visited = new boolean[n][m];
        visited[lever[0]][lever[1]] = true;

        while (!que.isEmpty()) {
            int[] tmp = que.poll();

            int r = tmp[0];
            int c = tmp[1];
            int cnt = tmp[2];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isValid(nr, nc, n, m) || !graph[nr][nc] || visited[nr][nc])
                    continue;

                if (nr == exit[0] && nc == exit[1]) {
                    return cnt + 1;
                }

                visited[nr][nc] = true;
                que.offer(new int[] { nr, nc, cnt + 1 });
            }
        }

        // 3. 반환
        return -1;
    }

    static boolean isValid(int r, int c, int n, int m) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
