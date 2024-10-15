import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int[][] graph;
    static int[][] dir = {{2, 0, 3, 0}, {0, 1, 1, 1}, {1, 1, 2, 0}, {1, -1, 1, 1}, {1, -1, 2, 0}, {0, -1, 0, 1},
            {0, 1, 0, 2}, {0, -1, 2, 0}, {1, -2, 1, -1}, {2, 0, 2, 1}, {1, 1, 2, 1}, {1, -1, 0, 1}, {0, -1, 1, 1},
            {-1, 1, 0, 1}, {0, -2, 0, -1}, {0, 1, 2, 0}, {1, 1, 1, 2}, {2, -1, 2, 0}};
    static int ans;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sum = 0;
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                sum += graph[i][j];
                if (j >= 3) {
                    ans = Math.max(ans, sum);
                    sum -= graph[i][j - 3];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 입력 및 초기화
        input();

        // 2. 로직
        for (int r = 0; r < n - 1; r++) {
            for (int c = 0; c < m; c++) {
                ans = Math.max(ans, graph[r][c] + graph[r + 1][c] + makeTetromino(r, c));
            }
        }

        // 3. 출력
        System.out.println(ans);
    }

    static int makeTetromino(int r, int c) {
        int max = 0;

        for (int[] arr : dir) {
            if (isValid(r + arr[0], c + arr[1]) && isValid(r + arr[2], c + arr[3])) {
                max = Math.max(max, graph[r + arr[0]][c + arr[1]] + graph[r + arr[2]][c + arr[3]]);
            }
        }

        return max;
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}