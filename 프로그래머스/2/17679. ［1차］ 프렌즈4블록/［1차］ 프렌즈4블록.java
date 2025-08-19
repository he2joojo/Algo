import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int solution(int m, int n, String[] board) {

        // 1. 초기 세팅
        List<Character>[] lists = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();

            for (int j = m - 1; j >= 0; j--) {
                lists[i].add(board[j].charAt(i));
            }
        }

        // 2. 로직
        boolean flag = true;
        int ans = 0;

        while (flag) {
            // 세팅
            flag = false;
            Set<int[]> set = new TreeSet<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] == b[0] && a[1] == b[1]) {
                        return 0;
                    }

                    if (a[1] != b[1]) {
                        return Integer.compare(b[1], a[1]);
                    }

                    return Integer.compare(a[0], b[0]);
                }
            });

            // 게임
            for (int i = 1; i < n; i++) {
                List<Character> line = lists[i];
                for (int j = 1; j < line.size(); j++) {
                    if (line.get(j - 1) == line.get(j)) {
                        List<Character> frontLine = lists[i - 1];
                        if (frontLine.size() <= j) {
                            continue;
                        }
                        if (frontLine.get(j - 1) == line.get(j - 1) && frontLine.get(j) == line.get(j)) {
                            set.add(new int[] { i - 1, j });
                            set.add(new int[] { i - 1, j - 1 });
                            set.add(new int[] { i, j });
                            set.add(new int[] { i, j - 1 });
                        }
                    }
                }
            }

            // 당기기
            if (!set.isEmpty()) {
                flag = true;
            }

            ans += set.size();

            for (int[] p : set) {
                lists[p[0]].remove(p[1]);
            }
        }

        // 3. 반환
        return ans;
    }
}
