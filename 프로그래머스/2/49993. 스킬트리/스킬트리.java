import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        // 1. 초기 세팅
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }

        // 2. 로직
        int answer = 0;

        for (String str : skill_trees) {
            int idx = 0;
            boolean isPossible = true;

            for (char ch : str.toCharArray()) {
                if (!map.containsKey(ch))
                    continue;

                if (map.get(ch) > idx) {
                    isPossible = false;
                    break;
                }

                idx++;
            }

            if (isPossible) {
                answer++;
            }
        }

        // 3. 반환
        return answer;
    }
}
