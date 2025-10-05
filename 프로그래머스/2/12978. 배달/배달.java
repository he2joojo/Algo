import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int N, int[][] road, int K) {

        // 1. 초기 실행
        List<int[]>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            int x = r[0];
            int y = r[1];
            int d = r[2];

            graph[x].add(new int[] { y, d });
            graph[y].add(new int[] { x, d });
        }

        // 2. 로직
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(1);

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int[] tmp : graph[now]) {
                int next = tmp[0];
                int d = tmp[1];

                if (dist[next] > dist[now] + d) {
                    dist[next] = dist[now] + d;
                    que.offer(next);
                }
            }
        }

        // 3. 반환
        int ans = 0;

        for (int a : dist) {
            if (a <= K)
                ans++;
        }

        return ans;
    }
}
