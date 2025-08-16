import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {

        // 1. 초기 세팅
        int n = files.length;
        String[][] splitFiles = new String[n][3];

        for (int i = 0; i < n; i++) {
            String str = files[i];
            int start = 0;
            int end = str.length();

            for (int j = 0; j < str.length(); j++) {
                if ('0' <= str.charAt(j) && str.charAt(j) <= '9' && start == 0) {
                    start = j;
                } else if (!('0' <= str.charAt(j) && str.charAt(j) <= '9') && start != 0) {
                    end = j;
                    break;
                }
            }
            splitFiles[i][0] = str.substring(0, start);
            splitFiles[i][1] = str.substring(start, end);
            if (end < str.length()) {
                splitFiles[i][2] = str.substring(end);
            } else {
                splitFiles[i][2] = "";
            }
        }

        // 2. 정렬
        Arrays.sort(splitFiles, (a, b) -> {
            if (a[0].equalsIgnoreCase(b[0])) {
                if (Integer.parseInt(a[1]) == Integer.parseInt(b[1])) {
                    return 0;
                }
                return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            }

            return a[0].toUpperCase().compareTo(b[0].toUpperCase());
        });

        // 3. 반환
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            ans[i] = splitFiles[i][0] + splitFiles[i][1] + splitFiles[i][2];
        }

        return ans;
    }
}
