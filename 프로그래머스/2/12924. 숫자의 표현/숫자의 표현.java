import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int n) {
        int answer = 0;

        Queue<Integer> que = new ArrayDeque<>();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            que.offer(i);
            sum += i;

            while (sum > n) {
                sum -= que.poll();
            }

            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }
}
