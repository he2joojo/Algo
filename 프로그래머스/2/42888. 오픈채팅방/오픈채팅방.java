import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 1. 초기 세팅
        Map<String, String> map = new HashMap<>();
        List<String> log = new ArrayList<>();
        List<String> uid = new ArrayList<>();

        final String ENTER = "님이 들어왔습니다.";
        final String LEAVE = "님이 나갔습니다.";

        // 2. 로직
        for (String str : record) {
            String[] tmp = str.split(" ");

            if (tmp[0].equals("Enter")) {
                map.put(tmp[1], tmp[2]);
                log.add(ENTER);
                uid.add(tmp[1]);
            } else if (tmp[0].equals("Leave")) {
                log.add(LEAVE);
                uid.add(tmp[1]);
            } else {
                map.put(tmp[1], tmp[2]);
            }
        }

        // 3. 반환
        String[] ans = new String[log.size()];

        for (int i = 0; i < log.size(); i++) {
            ans[i] = map.get(uid.get(i)) + log.get(i);
        }

        return ans;
    }
}
