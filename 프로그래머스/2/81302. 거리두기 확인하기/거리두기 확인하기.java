class Solution {
    public int[] solution(String[][] places) {

        // 1. 초기 세팅
        int n = 5;
        char[][] graph;

        int[] ans = new int[places.length];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = 1;
        }

        // 2. 로직
        for (int idx = 0; idx < ans.length; idx++) {

            graph = new char[n][n];

            for (int i = 0; i < n; i++) {
                graph[i] = places[idx][i].toCharArray();
            }

            loop: for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (graph[r][c] == 'P' && !isSafe(r, c, graph)) {
                        ans[idx] = 0;
                        break loop;
                    }
                }
            }
        }

        // 3. 반환
        return ans;
    }

    static boolean isSafe(int r, int c, char[][] graph) {
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if ((i == 0 && j == 0) || Math.abs(i) + Math.abs(j) > 2)
                    continue;

                int nr = r + i;
                int nc = c + j;

                if (!isValid(nr, nc))
                    continue;

                if (graph[nr][nc] == 'O' || graph[nr][nc] == 'X')
                    continue;

                // graph[nr][nc] == P
                if (Math.abs(i) + Math.abs(j) == 1) {
                    return false;
                }

                if (i != 0) {
                    int tmp = (i < 0) ? -1 : 1;

                    if (graph[r + tmp][c] != 'X') {
                        return false;
                    }
                }

                if (j != 0) {
                    int tmp = (j < 0) ? -1 : 1;

                    if (graph[r][c + tmp] != 'X') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < 5 && 0 <= c && c < 5;
    }
}
