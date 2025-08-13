import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {

        // 1. 초기 세팅
        Arrays.sort(A);
        Arrays.sort(B);

        // 2. 로직
        int n = A.length;
        int x = 0;
        int y = 0;
        int answer = 0;

        while (x < n && y < n) {
            if (A[x] < B[y]) {
                answer++;
                x++;
                y++;
            } else {
                y++;
            }
        }

        // 3. 반환
        return answer;
    }
}
