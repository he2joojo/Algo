import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int D;

    static List<int[]> ways;
    static int result;

    public static void main(String[] args) throws IOException {

        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        ways = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (to > D || (to - from) <= d) { // 도착지를 넘어가거나 or 지름길이 더 긴 경우
                continue;
            }

            ways.add(new int[]{from, to, d});
        }

        // 2. 로직
        ways.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];

            if (a[1] != b[1]) return a[1] - b[1];

            return a[2] - b[2];
        });

        result = D;

        dfs(0, 0, 0);

        // 3. 출력
        System.out.println(result);
    }

    static void dfs(int now, int idx, int tmp) {
        if (now == D) {
            result = Math.min(result, tmp);
            return;
        }

        if (idx >= ways.size()) {
            tmp += (D - now);
            result = Math.min(result, tmp);
            return;
        }

        // 선택 o
        int[] way = ways.get(idx);

        if (way[0] >= now) {
            dfs(way[1], idx + 1, tmp + way[2] + (way[0] - now));
        }

        // 선택 x
        dfs(now, idx + 1, tmp);
    }
}
