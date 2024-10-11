import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int n;
	static int k;
	static Queue<Integer> que;
	static int[] ans;

	static void input() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();

		que = new ArrayDeque();

		for (int i = 1; i <= n; i++) {
			que.offer(i);
		}

		ans = new int[n];
	}

	public static void main(String[] args) {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		int idx = 0;

		while (que.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				que.offer(que.poll());
			}
			ans[idx++] = que.poll();
		}

		ans[idx] = que.poll();

		// 3. 출력
		sb.append("<");

		for (int i = 0; i < n - 1; i++) {
			sb.append(ans[i]).append(", ");
		}

		sb.append(ans[n - 1]).append(">");

		System.out.println(sb.toString());
	}
}