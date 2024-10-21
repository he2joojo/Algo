import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static int m;
	static int[][] graph;
	static Queue<int[]> que;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[n][m];
		que = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
					que.offer(new int[] { i, j });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		// 0 -> 치즈로 둘러쌓인 구멍
		// 1 -> 치즈
		// 2 -> 공기

		graph[0][0] = 2;
		dfs(0, 0, new boolean[n][m]); // 치즈로 둘러쌓인 구멍 찾기(0 -> 2)

		int ans = 0;
		int len, cnt;
		int[] tmp;
		List<int[]> list;
		boolean[][] visited;

		while (!que.isEmpty()) {
			ans++;
			len = que.size();
			list = new ArrayList<>();
			for (int i = 0; i < len; i++) { // 치즈 녹는지 확인 -> 별도의 리스트에 저장
				cnt = 0;
				tmp = que.poll();
				for (int d = 0; d < 4; d++) {
					if (graph[tmp[0] + dr[d]][tmp[1] + dc[d]] == 2) {
						cnt++;
					}
				}
				if (cnt > 1) {
					list.add(tmp);
				} else {
					que.offer(tmp);
				}
			}

			len = list.size();
			for (int i = 0; i < len; i++) { // 치즈 2로 바꾸기
				tmp = list.get(i);
				graph[tmp[0]][tmp[1]] = 2;
			}

			visited = new boolean[n][m];
			for (int i = 0; i < list.size(); i++) { // 구멍(0)이 공기와 닿았는지 확인
				tmp = list.get(i);
				for (int d = 0; d < 4; d++) {
					if (graph[tmp[0] + dr[d]][tmp[1] + dc[d]] == 0) {
						dfs(tmp[0] + dr[d], tmp[1] + dc[d], visited);
					}
				}
			}
		}

		// 3. 출력
		System.out.println(ans);
	}

	static void dfs(int r, int c, boolean[][] visited) {
		visited[r][c] = true;
		graph[r][c] = 2;

		for (int d = 0; d < 4; d++) {
			if (isValid(r + dr[d], c + dc[d]) && graph[r + dr[d]][c + dc[d]] == 0 && !visited[r + dr[d]][c + dc[d]]) {
				graph[r + dr[d]][c + dc[d]] = 2;
				dfs(r + dr[d], c + dc[d], visited);
			}
		}
	}

	static boolean isValid(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}