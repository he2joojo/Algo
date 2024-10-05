import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] graph;
    static int[][] dp;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        graph = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][3];
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        dp[0][0] = graph[0][0];
        dp[0][1] = graph[0][1];
        dp[0][2] = graph[0][2];

        int tmp;

        for (int i = 1; i < n; i++) { // 각 집 순회
            for (int j = 0; j < 3; j++) { // 각 집의 RGB 경우 순회
                tmp = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) { // 앞 집 순회
                    if (k == j) {
                        continue;
                    }
                    tmp = Math.min(tmp, dp[i - 1][k]);
                }
                dp[i][j] = graph[i][j] + tmp;
            }
        }

        // 3. 출력
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }

        System.out.println(ans);
    }
}