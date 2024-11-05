import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;
	static List<Integer>[] graph;
	static int[] parent;
	static boolean[] visited;

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());

		graph = new List[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		int a;
		int b;

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		parent = new int[n + 1];
		visited = new boolean[n + 1];

		m = Integer.parseInt(br.readLine());
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		visited[1] = true;
		findParent(1, 1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			findLowestCommonAncestor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 3. 출력
		System.out.println(sb);
	}

	static void findParent(int p, int c) {
		parent[c] = p;

		for (int i = 0; i < graph[c].size(); i++) {
			if (!visited[graph[c].get(i)]) {
				visited[graph[c].get(i)] = true;
				findParent(c, graph[c].get(i));
			}
		}
	}

	static void findLowestCommonAncestor(int a, int b) {
		visited = new boolean[n + 1];

		while (a != parent[a]) {
			visited[a] = true;
			a = parent[a];
		}

		visited[a] = true;

		while (!visited[b]) {
			b = parent[b];
		}

		sb.append(b).append("\n");
	}
}