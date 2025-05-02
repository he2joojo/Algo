import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int L;
    static int R;
    static int[][] graph;

    static int ans;
    static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean[][] visited;
    static List<int[]> list;
    static int total;

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력
        input();

        // 2. 로직
        boolean flag = true;

        while (flag) {
            flag = false;

            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        list = new ArrayList<>();
                        total = 0;
                        dfs(i, j); // 국경선 열기기

                        if (list.size() > 1) {
                            int newPopulation = total / list.size();
                            for (int k = 0; k < list.size(); k++) { // 인구 이동
                                int r = list.get(k)[0];
                                int c = list.get(k)[1];
                                graph[r][c] = newPopulation;
                            }
                            flag = true;
                        }
                    }
                }
            }

            ans++;
        }

        // 3. 출력
        System.out.println(ans - 1);
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        list.add(new int[] { r, c });
        total += graph[r][c];

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (!isValid(nr, nc)) {
                continue;
            }

            int tmp = Math.abs(graph[r][c] - graph[nr][nc]);

            if (L <= tmp && tmp <= R && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
