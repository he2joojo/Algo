class Solution {

    static int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(0, numbers, 0, target);

        return answer;
    }

    static void dfs(int idx, int[] numbers, int tmp, int target) {
        if (idx == numbers.length) {
            if (tmp == target) {
                answer++;
            }
            return;
        }

        dfs(idx + 1, numbers, tmp + numbers[idx], target);
        dfs(idx + 1, numbers, tmp + (numbers[idx] * -1), target);
    }
}
