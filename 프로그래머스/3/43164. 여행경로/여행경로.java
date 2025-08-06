import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    static List<String> list;
    static int n;
    static boolean isFound;

    public String[] solution(String[][] tickets) {
        // 1. 초기 세팅
        list = new ArrayList<>();
        n = tickets.length;
        isFound = false;

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        // 2. 로직
        dfs("ICN", "ICN", 0, tickets, new boolean[n]);

        // 3. 반환
        return list.get(0).split(" ");
    }

    static void dfs(String start, String path, int cnt, String[][] tickets, boolean[] visited) {
        if (cnt == n) {
            list.add(path);
            isFound = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isFound) {
                return;
            }

            String[] tmp = tickets[i];

            if (tmp[0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tmp[1], path + " " + tmp[1], cnt + 1, tickets, visited);
                visited[i] = false;
            }
        }
    }
}
