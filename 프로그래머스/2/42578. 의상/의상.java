import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for (String[] arr : clothes) {
            String key = arr[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int answer = 1;

        for (int k : map.values()) {
            answer *= (k + 1);
        }

        return answer - 1;
    }
}
