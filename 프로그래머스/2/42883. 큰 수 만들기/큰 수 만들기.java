class Solution {
    public String solution(String number, int k) {

        // 1. 초기 세팅
        StringBuilder sb = new StringBuilder();

        // 2. 로직
        for (int i = 0; i < number.length(); i++) {

            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < number.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(number.charAt(i));
        }

        if (k > 0) {
            sb.delete(sb.length() - k, sb.length());
        }

        // 3. 반환
        return sb.toString();
    }
}
