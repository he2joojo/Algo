import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 1. 초기 세팅
        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < bridge_length; i++) {
            que.offer(0);
        }

        int time = 0;
        int idx = 0;
        int bridgeWeight = 0;

        // 2. 로직
        while (idx < truck_weights.length) {

            time++;
            bridgeWeight -= que.poll();

            int truck = truck_weights[idx];

            if (bridgeWeight + truck > weight) {
                que.offer(0);
                continue;
            }

            que.offer(truck);
            bridgeWeight += truck;
            idx++;
        }

        // 3. 반환
        return time + que.size();
    }
}
