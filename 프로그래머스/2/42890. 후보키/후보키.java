import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    static int n;
    static int m;

    static String[][] relations;
    static List<Set<Integer>> candidates;

    public int solution(String[][] relation) {

        // 1. 초기 세팅
        n = relation.length;
        m = relation[0].length;

        relations = relation;
        candidates = new ArrayList<>();

        // 2. 로직
        for (int i = 1; i <= m; i++) {
            combination(0, i, new HashSet<>());
        }

        // 3. 반환
        return candidates.size();
    }

    static void combination(int idx, int size, Set<Integer> keys) {

        if (keys.size() == size) {
            if (isUnique(keys) && isMinimal(keys)) {
                candidates.add(new HashSet<>(keys));
            }
            return;
        }

        for (int i = idx; i < m; i++) {
            keys.add(i);
            combination(i + 1, size, keys);
            keys.remove(i);
        }
    }

    static boolean isUnique(Set<Integer> keys) {

        Set<String> tmp = new HashSet<>();

        for (String[] r : relations) {
            StringBuilder sb = new StringBuilder();

            for (int k : keys) {
                sb.append(r[k]).append("|");
            }

            tmp.add(sb.toString());
        }

        return tmp.size() == relations.length;
    }

    static boolean isMinimal(Set<Integer> keys) {

        for (Set<Integer> c : candidates) {
            if (keys.containsAll(c)) {
                return false;
            }
        }

        return true;
    }
}
