import java.util.HashSet;
import java.util.Set;

class Solution {

    static Set<Integer> set;

    public int solution(String numbers) {
        // 1. 초기 세팅
        set = new HashSet<>();

        getNumber(numbers, "", new boolean[numbers.length()]);

        // 2. 로직
        int ans = 0;

        for (int k : set) {
            if (k < 2) {
                continue;
            }

            int n = (int) (Math.sqrt(k));
            boolean flag = true;

            for (int i = 2; i <= n; i++) {
                if (k % i == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans++;
            }
        }

        // 3. 반환
        return ans;

    }

    static void getNumber(String numbers, String tmp, boolean[] visited) {
        if (tmp.length() > 0) {
            set.add(Integer.parseInt(tmp));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                getNumber(numbers, tmp + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
}
