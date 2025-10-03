import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    static int n;
    static int m;

    static Set<String> set;
    static String[] ids;

    public int solution(String[] user_id, String[] banned_id) {

        // 1. 초기 세팅
        n = user_id.length;
        m = banned_id.length;

        set = new HashSet<>();
        ids = new String[m];

        // 2. 로직
        getList(0, new boolean[n], user_id, banned_id);

        // 3. 반환
        return set.size();
    }

    static void getList(int idx, boolean[] visited, String[] user_id, String[] banned_id) {
        if (idx >= m) {
            if (check(banned_id)) {
                addSet();
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ids[idx] = user_id[i];

                getList(idx + 1, visited, user_id, banned_id);

                visited[i] = false;
            }
        }
    }

    static boolean check(String[] banned_id) {
        for (int i = 0; i < m; i++) {

            String id = ids[i];
            String banId = banned_id[i];

            if (id.length() != banId.length())
                return false;

            for (int j = 0; j < id.length(); j++) {
                if (banId.charAt(j) == '*')
                    continue;

                if (id.charAt(j) != banId.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    static void addSet() {
        String[] tmp = ids.clone();
        Arrays.sort(tmp);

        StringBuilder sb = new StringBuilder();

        for (String str : tmp) {
            sb.append(str);
        }

        set.add(sb.toString());
    }
}
