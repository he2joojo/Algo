import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : tangerine) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            cnt++;
            if (sum >= k) {
                break;
            }
        }

        return cnt;
    }
}
