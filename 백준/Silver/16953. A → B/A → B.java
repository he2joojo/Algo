import java.util.Scanner;

public class Main {

	static int a;
	static int b;

	static void input() {

		Scanner sc = new Scanner(System.in);

		a = sc.nextInt();
		b = sc.nextInt();
	}

	public static void main(String[] args) {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		int ans = 1;
		boolean isPossible = true;

		while (true) {
			if (a == b) {
				break;
			} else if (b % 10 != 1 && b % 2 != 0 || b < a) {
				isPossible = false;
				break;
			}

			if (b % 10 == 1) {
				b /= 10;
				ans++;
				continue;
			} else if (b % 2 == 0) {
				b /= 2;
				ans++;
			}
		}

		// 3. 출력
		if (!isPossible) {
			ans = -1;
		}

		System.out.println(ans);
	}
}