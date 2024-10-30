import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[][] arr;
	static boolean end;

	static void input() throws IOException {

		arr = new int[9][9];
		String str;

		for (int i = 0; i < 9; i++) {
			str = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		out: for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (arr[i][j] == 0) {
					fill(i, j);
					break out;
				}
			}
		}

		// 3. 출력
	}

	static void fill(int r, int c) {
		// 기저조건 설정
		if (end) {
			return;
		}

		if (r == -1 && c == -1) {
			for (int i = 0; i < 9; i++) { // 더 이상 0이 없으면 출력
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			end = true;
			return;
		}

		// 숫자 채우기
		boolean[] exist = check(r, c);

		for (int i = 1; i < 10; i++) {
			if (!exist[i]) {
				arr[r][c] = i;
				int[] tmp = next(r, c);
				fill(tmp[0], tmp[1]);
			}
		}

		arr[r][c] = 0;
	}

	static int[] next(int r, int c) {

		for (int i = c + 1; i < 9; i++) { // 같은 행 확인
			if (arr[r][i] == 0) {
				return new int[] { r, i };
			}
		}

		for (int i = r + 1; i < 9; i++) { // 다음 행부터 확인
			for (int j = 0; j < 9; j++) {
				if (arr[i][j] == 0) {
					return new int[] { i, j };
				}
			}
		}

		return new int[] { -1, -1 };
	}

	static boolean[] check(int r, int c) {
		boolean[] tmp = new boolean[10];

		for (int i = 0; i < 9; i++) {
			tmp[arr[i][c]] = true; // 세로 줄 확인
			tmp[arr[r][i]] = true; // 가로 줄 확인
		}

		int nr = (r / 3) * 3;
		int nc = (c / 3) * 3;

		for (int i = nr; i < nr + 3; i++) { // 사각형 확인
			for (int j = nc; j < nc + 3; j++) {
				tmp[arr[i][j]] = true;
			}
		}

		return tmp;
	}
}