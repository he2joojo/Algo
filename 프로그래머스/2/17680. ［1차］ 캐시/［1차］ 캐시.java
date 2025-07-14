import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        Set<String> set = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>();

        int answer = 0;

        for (String city : cities) {

            city = city.toLowerCase();

            if (set.contains(city)) { // 캐시 히트
                answer += 1;
                deque.remove(city);
                deque.offerLast(city);
            } else { // 캐시 미스
                answer += 5;
                set.add(city);
                deque.offerLast(city);
            }

            // 캐시 사이즈 확인
            if (set.size() > cacheSize) {
                set.remove(deque.pollFirst());
            }
        }

        return answer;
    }
}
