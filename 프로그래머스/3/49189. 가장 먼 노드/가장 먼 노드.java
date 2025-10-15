import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {

        // 1. 초기 세팅
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] tmp : edge) {
            int a = tmp[0];
            int b = tmp[1];

            graph[a][b] = true;
            graph[b][a] = true;
        }

        // 2. 로직
        int[] dist = new int[n + 1];
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;
        que.offer(1);
        visited[0] = true;

        int maxLen = 0;
        int ans = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 1; i <= n; i++) {
                if (graph[cur][i] && !visited[i]) {

                    dist[i] = Math.min(dist[i], dist[cur] + 1);

                    que.offer(i);
                    visited[i] = true;

                    if (dist[i] > maxLen) {
                        maxLen = dist[i];
                        ans = 1;
                    } else if (dist[i] == maxLen) {
                        ans++;
                    }
                }
            }
        }

        // 3. 반환
        return ans;
    }
}
