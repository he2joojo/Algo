import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {

        // 1. 초기 세팅
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 2. 로직
        int sum = 0;

        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);

            if (pq.size() > k) {
                sum += pq.poll();
            }

            if (sum > n)
                return i;
        }

        // 3. 반환
        return enemy.length;
    }
}
