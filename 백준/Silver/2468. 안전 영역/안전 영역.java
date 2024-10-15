import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int min = 101;
    static int max = 0;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int nr;
    static int nc;
    static int count = 1;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, graph[i][j]);
                max = Math.max(max, graph[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 입력 및 초기화
        input();

        // 2. 로직
        int tmp = 0;

        for (int h = min; h < max; h++) {
            visited = new boolean[n][n];
            tmp = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (!visited[r][c] && graph[r][c] > h) {
                        tmp++;
                        dfs(r, c, h);
                    }
                }
            }
            count = Math.max(count, tmp);
        }

        // 3. 출력
        System.out.println(count);
    }

    static void dfs(int r, int c, int h) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            if (isValid(nr, nc) && !visited[nr][nc] && graph[nr][nc] > h) {
                dfs(nr, nc, h);
            }
        }
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}