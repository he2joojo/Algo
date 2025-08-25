import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 1. 초기 세팅
        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> que1 = new ArrayDeque<>();
        Queue<Integer> que2 = new ArrayDeque<>();

        for (int k : queue1) {
            sum1 += k;
            que1.offer(k);
        }

        for (int k : queue2) {
            sum2 += k;
            que2.offer(k);
        }

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        // 2. 로직
        int n = que1.size() * 2 + 2;
        int ans = 0;
        int t = 0;
        int tmp;

        while (t++ < n) {
            if (sum1 == sum2) {
                return ans;
            }

            ans++;

            if (sum1 > sum2) {
                if (que1.isEmpty()) {
                    return -1;
                }
                tmp = que1.poll();
                que2.offer(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            } else {
                if (que2.isEmpty()) {
                    return -1;
                }
                tmp = que2.poll();
                que1.offer(tmp);
                sum1 += tmp;
                sum2 -= tmp;
            }
        }

        // 3. 반환
        return (sum1 == sum2) ? ans : -1;
    }
}
