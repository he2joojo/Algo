class Solution {
    public int solution(int storey) {

        // 1. 초기 세팅
        int ans = 0;

        // 2. 로직
        while (storey > 0) {
            int now = storey % 10;
            int next = (storey / 10) % 10;

            if (now > 5) {
                ans += (10 - now);
                storey = storey / 10 + 1;
            } else if (now < 5) {
                ans += now;
                storey /= 10;
            } else {
                if (next >= 5) {
                    ans += (10 - now);
                    storey = storey / 10 + 1;
                } else {
                    ans += now;
                    storey /= 10;
                }
            }
        }

        // 3. 반환
        return ans;
    }
}
