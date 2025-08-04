import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {

        // 1. 초기 세팅
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int k : works) {
            pq.add(k);
        }

        System.out.println(pq);

        // 2. n번 순환
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                break;
            }

            int max = pq.poll();

            if (max > 1) {
                pq.add(max - 1);
            }
        }

        // 3. 반환
        long answer = 0;

        for (int k : pq) {
            answer += Math.pow(k, 2);
        }

        return answer;
    }
}
