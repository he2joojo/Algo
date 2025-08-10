import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 1. 초기 세팅
        final int MIDNIGHT = 23 * 60 + 59;

        // 2. 로직
        Map<Integer, Integer> input = new HashMap<>();
        Map<Integer, Integer> parkingTime = new TreeMap<>();

        for (String record : records) {
            String[] tmp = record.split(" ");

            int time = getTime(tmp[0]);
            int num = Integer.parseInt(tmp[1]);

            if (tmp[2].equals("IN")) {
                input.put(num, time);
            } else {
                time -= input.get(num);
                input.remove(num);
                parkingTime.put(num, parkingTime.getOrDefault(num, 0) + time);
            }
        }

        for (int num : input.keySet()) {
            int time = MIDNIGHT - input.get(num);
            parkingTime.put(num, parkingTime.getOrDefault(num, 0) + time);
        }

        System.out.println(parkingTime);

        // 3. 반환
        int[] ans = new int[parkingTime.size()];
        int idx = 0;

        for (int num : parkingTime.keySet()) {
            ans[idx] = getFee(fees, parkingTime.get(num));
            idx++;
        }

        return ans;
    }

    static int getTime(String time) {
        String[] tmp = time.split(":");
        return (Integer.parseInt(tmp[0]) * 60) + Integer.parseInt(tmp[1]);
    }

    static int getFee(int[] fees, int time) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        time -= basicTime;

        if (time <= 0) {
            return basicFee;
        }

        int unit = time / unitTime;

        if (time % unitTime > 0) {
            unit++;
        }

        return basicFee + (unit * unitFee);
    }
}
