import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(String[] board) {

        // 1. 초기 세팅
        int n = board.length;
        int m = board[0].length();

        char[][] map = new char[n][m];

        int r = 0;
        int c = 0;

        int[] exit = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char ch = board[i].charAt(j);
                map[i][j] = ch;

                if (ch == 'R') {
                    r = i;
                    c = j;
                } else if (ch == 'G') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }

        // 2. 로직
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        que.offer(new int[] { r, c, -1, 0 });
        visited[r][c] = true;

        while (!que.isEmpty()) {
            int[] tmp = que.poll();

            r = tmp[0];
            c = tmp[1];
            int dir = tmp[2];
            int cnt = tmp[3];

            for (int d = 0; d < 4; d++) {
                if (isReverse(d, dir))
                    continue;

                int nr = r;
                int nc = c;

                while (isValid(nr + dr[d], nc + dc[d], n, m, map)) {
                    nr += dr[d];
                    nc += dc[d];
                }

                if (visited[nr][nc])
                    continue;

                if (map[nr][nc] == 'G')
                    return cnt + 1;

                que.offer(new int[] { nr, nc, d, cnt + 1 });
                visited[nr][nc] = true;
            }
        }

        // 3. 반환
        return -1;
    }

    private boolean isValid(int r, int c, int n, int m, char[][] map) {
        if (r < 0 || n <= r || c < 0 || m <= c)
            return false;

        return map[r][c] != 'D';
    }

    private boolean isReverse(int d1, int d2) {
        if ((d1 == 0 && d2 == 1) || (d1 == 1 && d2 == 0))
            return true;
        if ((d1 == 2 && d2 == 3) || (d1 == 3 && d2 == 2))
            return true;
        return false;
    }
}
