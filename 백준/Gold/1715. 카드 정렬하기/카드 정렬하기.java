import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;
	static TreeSet<int[]> set;

	static void input() throws IOException {

		n = Integer.parseInt(br.readLine());

		set = new TreeSet<>((a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		for (int i = 0; i < n; i++) {
			set.add(new int[] { Integer.parseInt(br.readLine()), i });
		}
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		int sum = 0;
		int idx = n;
		int a;
		int b;

		while (set.size() > 1) {
			a = set.pollFirst()[0];
			b = set.pollFirst()[0];
			set.add(new int[] { a + b, idx++ });
			sum += (a + b);
		}

		// 3. 출력
		System.out.println(sum);
	}
}