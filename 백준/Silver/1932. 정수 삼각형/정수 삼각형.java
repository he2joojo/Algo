import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] graph;
    static int[][] dp;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        graph = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        dp[0][0] = graph[0][0];

        for (int i = 0; i < n - 1; i++) { // 계층 순회
            for (int j = 0; j < i + 1; j++) { // 계층의 요소 순회
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + graph[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + graph[i + 1][j + 1]);
            }
        }
        
        // 3. 출력
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[n - 1][i]);
        }

        System.out.println(ans);
    }
}