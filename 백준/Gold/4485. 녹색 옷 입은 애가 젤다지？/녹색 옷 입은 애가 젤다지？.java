import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int idx;
    static int N;
    static int[][] graph;

    static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

    public static void main(String[] args) throws IOException {

        // 1. 입력
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            idx++;

            graph = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 2. 로직
            int[][] cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }

            Queue<int[]> que = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            que.offer(new int[] { 0, 0, graph[0][0] });

            while (!que.isEmpty()) {
                int[] cur = que.poll();
                int r = cur[0];
                int c = cur[1];
                int fee = cur[2];

                if (r == N - 1 && c == N - 1) {
                    sb.append("Problem ").append(idx).append(": ").append(fee).append("\n");
                }

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (!isValid(nr, nc))
                        continue;

                    int newCost = fee + graph[nr][nc];

                    if (cost[nr][nc] > newCost) {
                        cost[nr][nc] = newCost;
                        que.offer(new int[] { nr, nc, newCost });
                    }
                }
            }
        }

        // 3. 출력
        System.out.println(sb);
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
