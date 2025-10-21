import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {

        // 1. 초기 세팅
        List<Integer> crews = new ArrayList<>();

        for (String str : timetable) {
            String[] tmp = str.split(":");

            int hour = Integer.parseInt(tmp[0]) * 60;
            int min = Integer.parseInt(tmp[1]);

            crews.add(hour + min);
        }

        Collections.sort(crews);

        // 2. 로직
        int time = 9 * 60;
        int idx = 0;

        for (int i = 1; i <= n; i++) {

            if (i == n) { // 마지막 버스

                boolean isFull = false;

                for (int j = 0; j < m && idx < crews.size(); j++) {
                    if (crews.get(idx) > time)
                        break;

                    if (j == m - 1) {
                        isFull = true;
                        break;
                    }
                    idx++;
                }

                if (isFull) {
                    time = crews.get(idx) - 1;
                }

                break;
            }

            for (int j = 0; j < m && idx < crews.size(); j++) {
                if (idx == crews.size() || crews.get(idx) > time)
                    break;

                idx++;
            }

            time += t;
        }

        // 3. 반환
        String hour = (time / 60) + "";
        String min = (time % 60) + "";

        if (hour.length() < 2) {
            hour = "0" + hour;
        }

        if (min.length() < 2) {
            min = "0" + min;
        }

        return hour + ":" + min;
    }
}
