import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int[] parent;
	static boolean[] visited;
	static int a;
	static int b;

	static void input() throws IOException {

		n = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int p;
		int c;

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			parent[c] = p;
		}

		st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			// 1. 입력
			input();

			// 2. 로직
			while (a != parent[a]) { // a를 최상위 노드로 이동시키기
				visited[a] = true;
				a = parent[a];
			}
			
			visited[a] = true;

			while (!visited[b]) { // b를 이동시키면서 방문했다면 공통조상 찾기 종료
				b = parent[b];
			}

			// 3. 출력
			sb.append(b).append("\n");
		}

		System.out.println(sb);
	}
}