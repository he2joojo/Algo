import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static int m;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	static void input() throws IOException {

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		int a, b;

		for (int i = 0; i < m; i++) { // 선행 관계 저장
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[b].add(a); // b가 나오기 위해서 a가 선행되어야 함
		}

		visited = new boolean[n + 1];
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}

		// 3. 출력
		System.out.println();
	}

	static void dfs(int k) {
		visited[k] = true;

		for (int i = 0; i < graph[k].size(); i++) {
			if (!visited[graph[k].get(i)]) {
				dfs(graph[k].get(i));
			}
		}

		System.out.print(k + " ");
	}
}