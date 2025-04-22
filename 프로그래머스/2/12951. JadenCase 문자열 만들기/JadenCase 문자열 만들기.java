class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        if ('a' <= s.charAt(0) && s.charAt(0) <= 'z') { // 맨 앞 문자가 소문자인 경우
            sb.append(String.valueOf(s.charAt(0)).toUpperCase());
        } else { 
            sb.append(s.charAt(0));
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ') { // 맨 앞 문자
                if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    sb.append(s.charAt(i));
                } else {
                    sb.append(String.valueOf(s.charAt(i)).toUpperCase());
                }
            } else { // 중간 문자
                if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    sb.append(s.charAt(i));
                } else {
                    sb.append(String.valueOf(s.charAt(i)).toLowerCase());
                }
            }
        }

        return sb.toString();
    }
}
