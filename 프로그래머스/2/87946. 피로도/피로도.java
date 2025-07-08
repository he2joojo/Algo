import java.util.Arrays;

class Solution {

    static int answer;
    static int n;

    public int solution(int k, int[][] dungeons) {

        n = dungeons.length;
        Arrays.sort(dungeons, (a, b) -> (b[0] - b[1]) - (a[0] - a[1]));

        dfs(k, 0, 0, dungeons);

        return answer;
    }

    static void dfs(int k, int tmp, int idx, int[][] dungeons) {
        if (idx >= n) {
            answer = Math.max(answer, tmp);
            return;
        }

        dfs(k, tmp, idx + 1, dungeons); // idx번째 선택 x

        if (k >= dungeons[idx][0]) { // idx번째 선택 o
            dfs(k - dungeons[idx][1], tmp + 1, idx + 1, dungeons);
        }
    }
}
