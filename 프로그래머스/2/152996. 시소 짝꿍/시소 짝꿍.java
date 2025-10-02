import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {

        // 1. 초기 세팅
        Map<Integer, Integer> map = new HashMap<>();

        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        // 2. 로직
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        long ans = 0;
        int n = list.size();

        for (int i = 0; i < n; i++) {
            int w = list.get(i);
            long cnt = (long) map.get(w);

            if (cnt > 1) {
                ans += ((cnt * (cnt - 1)) / 2);
            }

            for (int j = i + 1; j < n; j++) {
                int tmp = list.get(j);

                if (w * 3 == tmp * 2 || w * 4 == tmp * 3 || w * 4 == tmp * 2) {
                    ans += (cnt * map.get(tmp));
                }
            }
        }

        // 3. 반환
        return ans;
    }
}
