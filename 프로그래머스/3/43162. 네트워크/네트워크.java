import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    static int answer;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i, computers);
            }
        }

        return answer;
    }

    static void bfs(int idx, int[][] computers) {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(idx);
        visited[idx] = true;

        while (!que.isEmpty()) {
            int k = que.poll();

            for (int i = 0; i < computers.length; i++) {
                if (computers[k][i] == 1 && !visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
