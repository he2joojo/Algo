import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static String str1;
	static String str2;
	static int[][] dp;

	static void input() throws IOException {

		str1 = br.readLine();
		str2 = br.readLine();

		dp = new int[str1.length() + 1][str2.length() + 1]; // dp[1][2] -> str1(1~1)과 str2(1~2)까지 lcs 길이
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		for (int i = 1; i <= str1.length(); i++) { // lcs 길이 구하기 위해 dp배열 채우기
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int i = str1.length();
		int j = str2.length();

		while (i > 0 && j > 0) { // lcs 단어 구하기
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				sb.append(str1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		// 3. 출력
		System.out.println(dp[str1.length()][str2.length()]);
		System.out.println(sb.reverse().toString());
	}
}