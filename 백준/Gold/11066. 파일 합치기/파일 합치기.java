import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int[] sum;
	static int[][] dp;

	static void input() throws IOException {

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		sum = new int[n + 1];

		for (int i = 1; i <= n; i++) { // 누적합 계산
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}

		dp = new int[n + 1][n + 1];
	}

	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			// 1. 입력 및 초기화
			input();

			// 2. 로직
			int j;

			for (int len = 2; len <= n; len++) { // 합치는 파일 길이
				for (int i = 1; i + len - 1 <= n; i++) { // 파일 시작 인덱스
					j = i + len - 1; // 파일 마지막 인덱스
					dp[i][j] = Integer.MAX_VALUE;

					for (int k = i; k < j; k++) { // i ~ j 구간을 나누는 인덱스
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
					}
				}
			}

			// 3. 출력
			sb.append(dp[1][n]).append("\n");
		}

		System.out.println(sb.toString());
	}
}