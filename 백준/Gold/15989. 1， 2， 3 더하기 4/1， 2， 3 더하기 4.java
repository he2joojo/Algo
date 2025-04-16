import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T;
    static final int MAX = 10000;

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        // 1. 입력
        T = Integer.parseInt(br.readLine());

        // 2. 로직
        dp = new int[MAX + 1][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= MAX; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        // 3. 출력
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(dp[k][1] + dp[k][2] + dp[k][3]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
