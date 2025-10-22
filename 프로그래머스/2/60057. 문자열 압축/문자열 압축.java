class Solution {
    public int solution(String s) {

        // 1. 초기 세팅
        int n = s.length();
        int ans = s.length();

        // 2. 로직
        for (int k = 1; k <= n / 2; k++) {
            StringBuilder sb = new StringBuilder();

            int cnt = 1;
            String cur = s.substring(0, k);

            for (int i = k; i < n; i += k) {

                int end = Math.min(i + k, n);
                String next = s.substring(i, end);

                if (cur.equals(next)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        sb.append(cur);
                    } else {
                        sb.append(cnt).append(cur);
                        cnt = 1;
                    }

                    cur = next;
                }

                if (end == n) {
                    if (cnt == 1) {
                        sb.append(cur);
                    } else {
                        sb.append(cnt).append(cur);
                    }
                }
            }

            ans = Math.min(ans, sb.length());
        }

        // 3. 반환
        return ans;
    }
}
