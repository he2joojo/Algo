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
	static int[][] graph;
	static int r; // 아기상어 위치
	static int c;
	static int count; // 시간
	static int size; // 아기상어 크기
	static int eat; // 먹은 물고기 개수
	static int fishes;

	static int[] dr = { -1, 0, 0, 1 }; // 상좌우하
	static int[] dc = { 0, -1, 1, 0 };
	static int nr;
	static int nc;

	static void input() throws IOException {

		n = Integer.parseInt(br.readLine());

		graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 9) {
					r = i;
					c = j;
				} else if (graph[i][j] != 0) {
					fishes++;
				}
			}
		}

		size = 2;
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		while (fishes > 0) {
			// 아기상어 4방향 탐색
			Queue<int[]> que = new ArrayDeque<>();
			boolean[][] visited = new boolean[n][n];
			List<int[]> list = new ArrayList<>();
			boolean found = false;

			int tr = Integer.MAX_VALUE;
			int tc = Integer.MAX_VALUE;
			int d = Integer.MAX_VALUE;

			que.offer(new int[] { r, c, 0 });
			visited[r][c] = true;

			out: while (!que.isEmpty()) {
				int len = que.size();
				for (int i = 0; i < len; i++) {
					int[] tmp = que.poll();
					for (int j = 0; j < 4; j++) {
						nr = tmp[0] + dr[j];
						nc = tmp[1] + dc[j];
						if (isValid(nr, nc) && !visited[nr][nc]) {
							if (graph[nr][nc] == size || graph[nr][nc] == 0) {
								visited[nr][nc] = true;
								que.offer(new int[] { nr, nc, tmp[2] + 1 });
							} else if (graph[nr][nc] < size) {
								found = true;
								list.add(new int[] { nr, nc, tmp[2] + 1 });
							}
						}
					}
				}

				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						int[] arr = list.get(i);
						if (arr[2] < d) {
							tr = arr[0];
							tc = arr[1];
							d = arr[2];
						} else if (arr[2] == d) {
							if (arr[0] < tr || (arr[0] == tr && arr[1] < tc)) {
								tr = arr[0];
								tc = arr[1];
							}
						}
					}
					break out;
				}

			}

			// 먹을 수 있는지 체크
			if (!found) {
				break;
			}
			
			count += d;
			eat++;
			graph[r][c] = 0;
			r = tr;
			c = tc;
			graph[r][c] = 9;
			fishes--;

			// 아기상어 크기 체크
			if (eat == size) {
				size++;
				eat = 0;
			}
		}

		// 3. 출력
		System.out.println(count);
	}

	static boolean isValid(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}
}