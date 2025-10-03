import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {

        // 1. 초기 세팅
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];

            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. 로직
        int ans = n;

        for (int[] wire : wires) {
            // 전선 하나 끊기
            int x = wire[0];
            int y = wire[1];

            graph[x][y] = false;
            graph[y][x] = false;

            // bfs로 전력망 탐색
            Queue<Integer> que = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];

            que.offer(1);
            visited[1] = true;

            while (!que.isEmpty()) {
                int now = que.poll();

                for (int i = 1; i <= n; i++) {
                    if (graph[now][i] && !visited[i]) {
                        visited[i] = true;
                        que.offer(i);
                    }
                }
            }

            int cnt = 0;

            for (boolean b : visited) {
                if (b) {
                    cnt++;
                }
            }

            ans = Math.min(ans, Math.abs(cnt - (n - cnt)));

            if (ans == 0) {
                return 0;
            }

            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 3. 반환
        return ans;
    }
}
