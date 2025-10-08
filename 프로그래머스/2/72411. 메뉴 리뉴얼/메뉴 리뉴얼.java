import java.util.*;

class Solution {

    static Map<Integer, Map<String, Integer>> map;

    public String[] solution(String[] orders, int[] course) {

        // 1. 초기 세팅
        map = new HashMap<>();

        for (int k : course) {
            map.put(k, new HashMap<>());
        }

        // 2. 로직
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);

            getList(String.valueOf(arr), 0, "");
        }

        List<String> list = new ArrayList<>();

        for (int k : course) {
            Map<String, Integer> m = map.get(k);
            List<String> tmp = new ArrayList<>();
            int max = 2;

            for (String key : m.keySet()) {
                if (m.get(key) > max) {
                    max = m.get(key);
                    tmp = new ArrayList<>();
                    tmp.add(key);
                } else if (m.get(key) == max) {
                    tmp.add(key);
                }
            }

            list.addAll(tmp);
        }

        // 3. 반환
        Collections.sort(list);
        
        String[] ans = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    static void getList(String str, int idx, String tmp) {
        if (idx == str.length()) {

            if (map.containsKey(tmp.length())) {
                Map<String, Integer> m = map.get(tmp.length());
                m.put(tmp, m.getOrDefault(tmp, 0) + 1);
            }

            return;
        }

        getList(str, idx + 1, tmp + str.charAt(idx));
        getList(str, idx + 1, tmp);
    }
}
