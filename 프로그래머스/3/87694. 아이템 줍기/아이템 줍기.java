import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        // 1. 초기 세팅
        final int N = 51 * 2;
        boolean[][] map = new boolean[N][N];

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                map[i][y1] = true;
                map[i][y2] = true;
            }

            for (int i = y1; i <= y2; i++) {
                map[x1][i] = true;
                map[x2][i] = true;
            }
        }

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[i][j] = false;
                }
            }
        }

        // 2. 로직
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        que.offer(new int[] { characterX * 2, characterY * 2, 0 });
        visited[characterX * 2][characterY * 2] = true;

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int x = tmp[0];
            int y = tmp[1];
            int cnt = tmp[2];

            if (x == (itemX * 2) && y == (itemY * 2)) {
                return cnt / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny, N) && map[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.offer(new int[] { nx, ny, cnt + 1 });
                }
            }
        }

        // 3. 반환
        return 0;
    }

    static boolean isValid(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
