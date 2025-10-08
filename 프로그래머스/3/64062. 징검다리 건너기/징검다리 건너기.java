import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[] stones, int k) {

        // 1. 초기 세팅
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;

        // 2. 로직
        for (int i = 0; i < stones.length; i++) {
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                ans = Math.min(ans, stones[deque.peekFirst()]);
            }
        }

        // 3. 반환
        return ans;
    }
}
