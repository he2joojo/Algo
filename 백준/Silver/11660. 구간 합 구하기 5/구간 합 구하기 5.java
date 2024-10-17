import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;
	static int[][] arr;
	static int[][] sum;

	static void input() throws IOException {

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sum = new int[n][n];
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		for (int i = 0; i < n; i++) {
			sum[i][0] = arr[i][0];
			for (int j = 1; j < n; j++) {
				sum[i][j] = sum[i][j - 1] + arr[i][j];
			}
		}

		int r, c, nr, nc, ans;

		for (int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			nr = Integer.parseInt(st.nextToken()) - 1;
			nc = Integer.parseInt(st.nextToken()) - 1;

			ans = 0;

			for (int i = r; i <= nr; i++) {
				ans += sum[i][nc];
				if (c > 0) {
					ans -= sum[i][c - 1];
				}
			}

			sb.append(ans).append("\n");
		}

		// 3. 출력
		System.out.println(sb.toString());
	}
}