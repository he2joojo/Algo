class Solution {
    public int solution(int[] players, int m, int k) {

        // 1. 초기 세팅
        int[] servers = new int[24];

        // 2. 로직
        int cnt = 0;

        for (int i = 0; i < 24; i++) {
            int server = players[i] / m;

            if (server == 0 || server <= servers[i])
                continue;

            int add = server - servers[i];

            for (int j = i; j < i + k && j < 24; j++) {
                servers[j] += add;
            }

            cnt += add;
        }

        // 3. 반환
        return cnt;
    }
}
