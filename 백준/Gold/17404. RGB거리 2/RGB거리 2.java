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
    static int[][][] dp;
    static final int MAX = 100_0000;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][3][2];
    }

    public static void main(String[] args) throws IOException {
        // 1. 입력 및 초기화
        input();

        // 2. 로직
        int min;

        for (int i = 0; i < 3; i++) { // 인덱스 1행 RGB 순회
            dp[1][i][0] = arr[1][i];
            min = MAX;
            for (int j = 0; j < 3; j++) { // 인덱스 0행 RGB 순회
                if (i == j) {
                    continue;
                }
                if (min > arr[0][j]) {
                    min = arr[0][j];
                    dp[1][i][1] = j;
                }
            }
            dp[1][i][0] += min;
        }

        int idx = 0;

        for (int i = 2; i < n - 1; i++) { // 2 ~ n-2 행 순회
            for (int j = 0; j < 3; j++) { // 각 행의 RGB 순회
                dp[i][j][0] = arr[i][j];
                min = MAX;
                for (int k = 0; k < 3; k++) { // 이전 행에서 가장 작은 값 찾기
                    if (j == k) {
                        continue;
                    }
                    if (min > dp[i - 1][k][0]) {
                        min = dp[i - 1][k][0];
                        idx = k;
                    }
                }
                dp[i][j][0] += min;
                dp[i][j][1] += dp[i - 1][idx][1];
            }
        }

        for (int i = 0; i < 3; i++) { // n-1 행 순회
            if (n < 3) {
                break;
            }
            min = MAX;
            dp[n - 1][i][0] = arr[n - 1][i];
            for (int j = 0; j < 3; j++) {
                if (i == j || i == dp[n - 2][j][1]) {
                    continue;
                }
                min = Math.min(min, dp[n - 2][j][0]);
            }
            dp[n - 1][i][0] += min;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) { // 최솟값 찾기
            ans = Math.min(ans, dp[n - 1][i][0]);
        }

//----------------------------------------------------------------------------------
        for (int i = 0; i < 3; i++) { // 인덱스 n-2 행 RGB 순회
            dp[n - 2][i][0] = arr[n - 2][i];
            min = MAX;
            for (int j = 0; j < 3; j++) { // 인덱스 n-1행 RGB 순회
                if (i == j) {
                    continue;
                }
                if (min > arr[n - 1][j]) {
                    min = arr[n - 1][j];
                    dp[n - 2][i][1] = j;
                }
            }
            dp[n - 2][i][0] += min;
        }

        for (int i = n - 3; i > 0; i--) { // n-3 ~ 1 행 순회
            for (int j = 0; j < 3; j++) { // 각 행의 RGB 순회
                dp[i][j][0] = arr[i][j];
                min = MAX;
                for (int k = 0; k < 3; k++) { // 이전 행에서 가장 작은 값 찾기
                    if (j == k) {
                        continue;
                    }
                    if (min > dp[i + 1][k][0]) {
                        min = dp[i + 1][k][0];
                        idx = k;
                    }
                }
                dp[i][j][0] += min;
                dp[i][j][1] = dp[i + 1][idx][1];
            }
        }

        for (int i = 0; i < 3; i++) { // 0 행 순회
            if (n < 3) {
                break;
            }
            min = MAX;
            dp[0][i][0] = arr[0][i];
            for (int j = 0; j < 3; j++) {
                if (i == j || i == dp[1][j][1]) {
                    continue;
                }
                min = Math.min(min, dp[1][j][0]);
            }
            dp[0][i][0] += min;
        }

//        System.out.println(Arrays.deepToString(dp));

        for (int i = 0; i < 3; i++) { // 최솟값 찾기
            ans = Math.min(ans, dp[0][i][0]);
        }

        // 3. 출력
        System.out.println(ans);
    }
}