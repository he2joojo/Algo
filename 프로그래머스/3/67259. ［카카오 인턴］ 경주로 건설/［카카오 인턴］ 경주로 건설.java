import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public int solution(int[][] board) {

        // 1. 초기 세팅
        int n = board.length;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        // 2. 로직
        Queue<int[]> que = new ArrayDeque<>();
        int[][][] cost = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        if (board[0][1] == 0) {
            que.offer(new int[] { 0, 1, 3, 100 });
            cost[0][1][3] = 100;
        }

        if (board[1][0] == 0) {
            que.offer(new int[] { 1, 0, 1, 100 });
            cost[1][0][1] = 100;
        }

        while (!que.isEmpty()) {
            int[] tmp = que.poll();

            int r = tmp[0];
            int c = tmp[1];
            int dir = tmp[2];
            int count = tmp[3];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isValid(nr, nc, n) || board[nr][nc] == 1)
                    continue;

                int cnt = count + 100;

                if (dir != d) {
                    cnt += 500;
                }

                if (cost[nr][nc][d] > cnt) {
                    que.offer(new int[] { nr, nc, d, cnt });
                    cost[nr][nc][d] = cnt;
                }
            }
        }

        // 3. 반환
        int ans = Integer.MAX_VALUE;

        for (int k : cost[n - 1][n - 1]) {
            ans = Math.min(ans, k);
        }

        return ans;
    }

    private boolean isValid(int r, int c, int n) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}
