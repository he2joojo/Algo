class Solution {

    static int[] ans;

    public int[] solution(int[][] arr) {
        // 1. 초기 세팅
        ans = new int[2];

        // 2. 로직
        zip(arr, 0, 0, arr.length);

        // 3. 반환
        return ans;
    }

    static void zip(int[][] arr, int x, int y, int size) {
        int first = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    int half = size / 2;
                    zip(arr, x, y, half);
                    zip(arr, x + half, y, half);
                    zip(arr, x, y + half, half);
                    zip(arr, x + half, y + half, half);
                    return;
                }
            }
        }

        ans[first]++;
    }
}
