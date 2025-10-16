import java.util.PriorityQueue;

class Solution {

    static int n;
    static int m;

    static int[][] board;
    static boolean[][] visited;
    static PriorityQueue<Integer> pq;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public int[] solution(String[] maps) {

        // 1. 초기 세팅
        n = maps.length;
        m = maps[0].length();

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = maps[i].charAt(j);

                if (ch != 'X') {
                    board[i][j] = ch - '0';
                }
            }
        }

        visited = new boolean[n][m];
        pq = new PriorityQueue<>();

        // 2. 로직
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0 && !visited[i][j]) {
                    pq.add(dfs(i, j));
                }
            }
        }

        // 3. 반환
        if (pq.isEmpty())
            return new int[] { -1 };

        int[] ans = new int[pq.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }

    static int dfs(int r, int c) {

        visited[r][c] = true;
        int ans = board[r][c];

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (isValid(nr, nc) && board[nr][nc] > 0 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                ans += dfs(nr, nc);
            }
        }

        return ans;
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
