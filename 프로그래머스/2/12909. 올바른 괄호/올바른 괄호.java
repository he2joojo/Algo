class Solution {
    boolean solution(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') { // 괄호 스택에 넣기
                count++;
            } else {
                count--;
            }

            if (count < 0) { // 확인
                return false;
            }
        }

        return count == 0;
    }
}
