class Solution {
    public int solution(int n, int[] stations, int w) {
        // 1. 초기 세팅

        // 2. 로직
        int cnt = 0;

        int p = 1 + w;
        int idx = 0;
        final int COVER = 2 * w + 1;

        while (p - w <= n) {
            if (idx < stations.length && stations[idx] <= p) {
                p = stations[idx] + COVER;
                idx++;
            } else {
                cnt++;
                p += COVER;
            }
        }

        // 3. 반환
        return cnt;
    }
}
