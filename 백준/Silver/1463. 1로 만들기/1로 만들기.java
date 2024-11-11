import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 2. 로직
		int[] dp = new int[n + 1];
		dp[1] = 0;
		if (n >= 2) {
			dp[2] = 1;
		}
		if (n >= 3) {
			dp[3] = 1;
		}

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		// 3. 출력
		System.out.println(dp[n]);
	}
}