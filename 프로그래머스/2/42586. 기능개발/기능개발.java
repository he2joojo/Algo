import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        // 1. 완료 날짜 구하기
        int n = progresses.length;
        int[] days = new int[n];

        if (n == 1) {
            return new int[] { 1 };
        }

        for (int i = 0; i < n; i++) {
            int rest = 100 - progresses[i];
            days[i] = rest / speeds[i];
            if (rest % speeds[i] > 0) {
                days[i]++;
            }
        }

        // 2. 배포 날짜 계산
        List<Integer> list = new ArrayList<>();
        int tmp = days[0];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (tmp >= days[i]) {
                cnt++;
                continue;
            }
            list.add(cnt);
            tmp = days[i];
            cnt = 1;
        }

        list.add(cnt);

        // 3. 반환
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
