import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        // 1. 초기 세팅
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put((char) (65 + i) + "", i + 1);
        }

        // 2. 순환
        List<Integer> list = new ArrayList<>();
        int i = 0;

        while (i < msg.length()) {
            String str = msg.charAt(i) + "";
            int j = i + 1;

            while (j < msg.length() && map.containsKey(str + msg.charAt(j))) {
                str += msg.charAt(j);
                j++;
            }

            list.add(map.get(str));
            if (j < msg.length()) {
                map.put(str + msg.charAt(j), map.size() + 1);
            }
            i = j;
        }

        // 3. 반환
        int[] answer = new int[list.size()];

        for (int k = 0; k < answer.length; k++) {
            answer[k] = list.get(k);
        }

        return answer;
    }
}
