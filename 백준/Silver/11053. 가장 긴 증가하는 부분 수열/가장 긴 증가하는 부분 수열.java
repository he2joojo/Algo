import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static int[] arr;
	static int[] dp;

	static void input() throws IOException {

		n = Integer.parseInt(br.readLine());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[n];
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		dp[0] = 1;
		int max;

		for (int i = 1; i < n; i++) {
			max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
		}

		// 3. 출력
		int ans = 1;
		
		for (int k : dp) {
			ans = Math.max(ans, k);
		}
		
		System.out.println(ans);
	}
}