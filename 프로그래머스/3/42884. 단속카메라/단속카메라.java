import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 1. 초기 세팅
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        // 2. 로직
        int camCnt = 0;
        int camPos = Integer.MIN_VALUE;

        for (int[] r : routes) {
            int start = r[0];
            int end = r[1];

            if (start > camPos) {
                camPos = end;
                camCnt++;
            }
        }

        // 3. 반환
        return camCnt;
    }
}
