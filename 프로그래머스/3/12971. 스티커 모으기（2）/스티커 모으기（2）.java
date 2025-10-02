class Solution {
    public int solution(int sticker[]) {

        // 1. 초기 세팅
        int n = sticker.length;

        if (n == 1) {
            return sticker[0];
        } else if (n == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        // 2. 로직
        int tmp1 = dp(sticker, 0, n - 1);
        int tmp2 = dp(sticker, 1, n - 1);

        // 3. 반환
        return Math.max(tmp1, tmp2);
    }

    static int dp(int[] sticker, int l, int k) {
        int[] arr = new int[k];

        arr[0] = sticker[l];
        arr[1] = Math.max(sticker[l], sticker[l + 1]);

        for (int i = 2; i < k; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + sticker[l + i]);
        }

        return arr[k - 1];
    }
}
