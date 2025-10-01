class Solution {
    public int[] solution(int[] sequence, int k) {

        // 1. 초기 세팅
        int[] ans = new int[2];
        int n = sequence.length;

        ans[1] = n;

        // 2. 로직
        int tmp = sequence[0];
        int front = 0;
        int back = 0;

        while (true) {
            while (tmp < k && front < n) {
                tmp += sequence[++front];
            }

            while (tmp > k && back < n) {
                tmp -= sequence[back++];
            }

            if (tmp == k) {
                if (front - back < ans[1] - ans[0]) {
                    ans[0] = back;
                    ans[1] = front;
                }
            }

            if (++front >= n) {
                break;
            }

            tmp += sequence[front];
        }

        // 3. 반환
        return ans;
    }
}
