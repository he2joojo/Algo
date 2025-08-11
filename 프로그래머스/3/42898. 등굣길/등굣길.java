class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 1. 초기 세팅
        boolean[][] water = new boolean[n][m];

        for (int[] p : puddles) {
            water[p[1] - 1][p[0] - 1] = true;
        }

        // 2. DP
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (water[r][c]) {
                    dp[r][c] = 0;
                    continue;
                }

                if (r == 0 && c == 0) {
                    continue;
                }

                int fromUp = (r > 0) ? dp[r - 1][c] : 0;
                int fromLeft = (c > 0) ? dp[r][c - 1] : 0;

                dp[r][c] = (fromUp + fromLeft) % 1_000_000_007;
            }
        }

        // 3. 반환
        return dp[n - 1][m - 1];
    }
}
