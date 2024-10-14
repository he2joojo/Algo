import java.util.Scanner;

public class Main {

	static int count;

	public static void main(String[] args) {

		// 1. 입력 및 초기화
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		// 2. 로직
		int size = (int) Math.pow(2, n);
		divide(size, r, c);

		// 3. 출력
		System.out.println(count);
	}

	static void divide(int size, int r, int c) {
		if (size == 1) {
			return;
		}

		int half = size / 2;

		if (r < half && c < half) { // 1사분면
			divide(half, r, c);
		} else if (r < half && c >= half) { // 2사분면
			count += half * half;
			divide(half, r, c - half);
		} else if (r >= half && c < half) { // 3사분면
			count += 2 * (half * half);
			divide(half, r - half, c);
		} else { // 4사분면
			count += 3 * (half * half);
			divide(half, r - half, c - half);
		}
	}
}