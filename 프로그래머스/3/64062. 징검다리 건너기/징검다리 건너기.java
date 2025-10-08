import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int[] stones, int k) {

        // 1. 초기 세팅
        int left = 0;
        int right = 0;

        for (int s : stones) {
            right = Math.max(right, s);
        }

        int ans = 0;

        // 2. 로직
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(stones, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 3. 반환
        return ans;
    }

    static boolean canCross(int[] stones, int k, int m) {
        int cnt = 0;

        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - m < 0) {
                cnt++;
                if (cnt >= k)
                    return false;
            } else {
                cnt = 0;
            }
        }

        return true;
    }
}
