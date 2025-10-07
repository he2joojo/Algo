import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] gems) {

        // 1. 초기 세팅
        int n = gems.length;
        int k = new HashSet<>(Arrays.asList(gems)).size();

        // 2. 로직
        int[] ans = new int[2];
        ans[0] = 0;
        ans[1] = n;

        int left = 0;
        int right = 0;

        Map<String, Integer> map = new HashMap<>();
        String g;

        while (right < n) {

            // 오른쪽 확장
            while (map.size() < k) {
                if (right == n)
                    break;
                g = gems[right++];
                map.put(g, map.getOrDefault(g, 0) + 1);
            }

            // 왼쪽 줄이기
            while (map.size() == k) {
                g = gems[left];

                if (map.get(g) == 1)
                    break;

                map.put(g, map.get(g) - 1);
                left++;
            }

            // 정답 갱신
            if (right - left < ans[1] - ans[0]) {
                ans[0] = left;
                ans[1] = right;
            }

            // left 이동
            g = gems[left];

            if (map.get(g) == 1) {
                map.remove(g);
            } else {
                map.put(g, map.get(g) - 1);
            }

            if (++left == n)
                break;
        }

        // 3. 반환
        ans[0] += 1;

        return ans;
    }
}
