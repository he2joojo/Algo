import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {

        // 1. 초기화
        int n = topping.length;
        int[] front = new int[n];
        int[] back = new int[n];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(topping[i]);
            front[i] = set.size();
        }

        set = new HashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            set.add(topping[i]);
            back[i] = set.size();
        }

        // 2. 개수 세기

        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            if (front[i] == back[i + 1])
                answer++;
        }

        return answer;
    }
}
