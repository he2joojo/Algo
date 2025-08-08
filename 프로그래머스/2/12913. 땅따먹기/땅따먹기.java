class Solution {
    int solution(int[][] land) {
        // 1. 초기 세팅
        int n = land.length;

        // 2. 로직
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        max = Math.max(max, land[i][k]);
                    }
                }
                land[i + 1][j] += max;
            }
        }

        // 3. 반환
        int ans = 0;

        for (int k : land[n - 1]) {
            ans = Math.max(ans, k);
        }

        return ans;
    }
}
