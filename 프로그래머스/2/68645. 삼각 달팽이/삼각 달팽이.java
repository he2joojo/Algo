class Solution {
    public int[] solution(int n) {

        // 1. 초기 세팅
        int[][] tri = new int[n][n];

        // 2. 로직
        int[] dr = { 1, 0, -1 };
        int[] dc = { 0, 1, -1 };

        int r = 0;
        int c = 0;

        int dir = 0;

        int total = (n * (n + 1)) / 2;
        int num = 1;

        while (num <= total) {
            tri[r][c] = num++;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (!isValid(nr, nc, n) || tri[nr][nc] != 0) {
                dir = (dir + 1) % 3;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
        }

        // 3. 반환
        int[] ans = new int[total];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                ans[idx++] = tri[i][j];
            }
        }

        return ans;
    }

    static boolean isValid(int r, int c, int n) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}
