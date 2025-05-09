public class Solution {
    public int solution(int n) {
        return dp(n);
    }

    static int dp(int n) {
        if (n == 1) {
            return 1;
        }

        if (n % 2 == 0) {
            return dp(n / 2);
        }

        return dp(n / 2) + 1;
    }
}
