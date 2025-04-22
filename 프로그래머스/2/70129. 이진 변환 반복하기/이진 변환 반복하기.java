class Solution {
    public int[] solution(String s) {
        
        int t = 0;
        int zeroCnt = 0;

        while (s.length() > 1) {
            t++;

            // 0 제거하기
            int tmp = s.length();
            s = s.replace("0", "");
            zeroCnt += (tmp - s.length());

            // 이진수로 바꾸기
            StringBuilder sb = new StringBuilder();
            tmp = s.length();

            while (tmp > 0) {
                sb.append(tmp % 2);
                tmp /= 2;
            }

            s = sb.reverse().toString();
        }

        return new int[] {t, zeroCnt};
    }
}
