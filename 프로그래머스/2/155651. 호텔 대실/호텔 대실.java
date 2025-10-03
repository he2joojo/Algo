import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {

        // 1. 초기 세팅
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));

        // 2. 로직
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;

        for (String[] tmp : book_time) {
            int start = toMin(tmp[0]);
            int end = toMin(tmp[1]) + 10;

            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
            ans = Math.max(ans, pq.size());
        }

        // 3. 반환
        return ans;
    }

    static int toMin(String str) {
        String[] tmp = str.split(":");

        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}
