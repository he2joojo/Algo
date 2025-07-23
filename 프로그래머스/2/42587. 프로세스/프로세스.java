import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[] priorities, int location) {

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            deque.addLast(new int[] { i, priorities[i] });
        }

        int answer = 0;

        while (!deque.isEmpty()) {
            // 우선순위가 가장 높은지 확인
            int[] head = deque.pollFirst();
            boolean isMax = true;

            for (int[] next : deque) {
                if (head[1] < next[1]) {
                    deque.addLast(head);
                    isMax = false;
                    break;
                }
            }

            if (!isMax)
                continue;

            answer++;
            if (head[0] == location) {
                return answer;
            }
        }

        return answer;
    }
}
