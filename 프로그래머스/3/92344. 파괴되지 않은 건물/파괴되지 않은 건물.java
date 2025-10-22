class Solution {
    public int solution(int[][] board, int[][] skill) {

        // 1. 초기 세팅
        int n = board.length;
        int m = board[0].length;

        int[][] acc = new int[n + 1][m + 1];

        // 2. 로직
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];

            if (type == 1) {
                degree *= -1;
            }

            acc[r1][c1] += degree;
            acc[r1][c2 + 1] -= degree;
            acc[r2 + 1][c1] -= degree;
            acc[r2 + 1][c2 + 1] += degree;
        }

        for (int i = 0; i < n; i++) { // 가로 누적 합
            for (int j = 1; j < m; j++) {
                acc[i][j] += acc[i][j - 1];
            }
        }

        for (int i = 1; i < n; i++) { // 세로 누적 합
            for (int j = 0; j < m; j++) {
                acc[i][j] += acc[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += acc[i][j];
            }
        }

        // 3. 반환
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
