import java.util.Arrays;

class Solution {

    public int solution(int x, int y, int n) {

        // 1. 초기 세팅
        if (x == y) {
            return 0;
        }

        int[] dp = new int[y + 1];

        int INF = 1_000_000_000;
        Arrays.fill(dp, INF);
        dp[x] = 0;

        // 2. DP
        for (int i = x + 1; i <= y; i++) {

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i - n >= x) {
                dp[i] = Math.min(dp[i], dp[i - n] + 1);
            }
        }

        // 3. 반환
        return dp[y] == INF ? -1 : dp[y];
    }
}
