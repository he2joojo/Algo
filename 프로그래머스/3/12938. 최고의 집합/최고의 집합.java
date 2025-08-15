import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        // 1. 초기 세팅
        if (n > s) {
            return new int[] { -1 };
        }

        int base = s / n;
        int rest = s % n;

        int[] answer = new int[n];
        Arrays.fill(answer, base);

        // 2. 로직
        for (int i = n - rest; i < n; i++) {
            answer[i]++;
        }

        // 3. 반환
        return answer;
    }
}
