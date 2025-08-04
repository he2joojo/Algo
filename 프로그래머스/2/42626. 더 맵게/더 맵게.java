import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 1. 초기 세팅
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : scoville) {
            pq.add(n);
        }

        // 2. 로직
        int answer = 0;

        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }

            answer++;

            int first = pq.poll();
            int second = pq.poll();

            pq.add(first + (second * 2));
        }

        // 3. 반환
        return answer;
    }
}
