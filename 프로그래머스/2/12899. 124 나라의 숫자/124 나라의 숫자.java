class Solution {
    public String solution(int n) {

        // 1. 초기 세팅
        String[] digit = { "1", "2", "4" };

        StringBuilder sb = new StringBuilder();

        // 2. 로직
        while (n > 0) {
            n--;
            sb.append(digit[n % 3]);
            n /= 3;
        }

        // 3. 반환
        return sb.reverse().toString();
    }
}
