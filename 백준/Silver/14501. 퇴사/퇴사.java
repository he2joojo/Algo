import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static int[][] dp;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 2][n + 2];
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        int idx;

        for (int i = 1; i <= n; i++) { // 각 상담 순회
            idx = i + arr[i][0];
            for (int j = 1; j <= n + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= idx) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][i] + arr[i][1]);
                }
            }
        }
        
        // 3. 출력
        System.out.println(dp[n][n + 1]);
    }
}