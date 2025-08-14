class Solution {
    public int solution(int n) {
        // 1. 초기 세팅
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        // 2. 로직
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1_000_000_007;
        }

        // 3. 반환
        return arr[n];
    }
}
