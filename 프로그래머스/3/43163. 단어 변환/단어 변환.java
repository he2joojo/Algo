import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {

        // 1. 초기 세팅
        Queue<int[]> que = new ArrayDeque<>();
        int n = words.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (canChange(begin, words[i])) {
                que.offer(new int[] { i, 1 });
                visited[i] = true;
            }
        }

        // 2. bfs
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            String now = words[tmp[0]];
            int cnt = tmp[1];

            if (now.equals(target)) {
                return cnt;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i] && canChange(now, words[i])) {
                    que.offer(new int[] { i, cnt + 1 });
                    visited[i] = true;
                }
            }
        }

        // 3. 반환
        return 0;
    }

    static boolean canChange(String str, String target) {
        int diff = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != target.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
