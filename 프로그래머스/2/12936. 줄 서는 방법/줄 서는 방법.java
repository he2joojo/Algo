import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {

        // 1. 초기 세팅
        long[] fact = new long[n + 1];
        List<Integer> nums = new LinkedList<>();

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            nums.add(i);
        }

        // 2. 로직
        int[] ans = new int[n];

        k--;

        for (int i = n; i > 0; i--) {
            long idx = k / fact[i - 1];
            k %= fact[i - 1];

            ans[n - i] = nums.get((int) idx);
            nums.remove((int) idx);
        }

        // 3. 반환
        return ans;
    }
}
