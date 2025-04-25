import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;

    static List<int[]>[] graph;

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[] { b, c });
            graph[b].add(new int[] { a, c });
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력
        input();

        // 2. 로직
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] { 1, 0 });

        int[] min = new int[N + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[1] = 0;

        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int cur = tmp[0];
            int count = tmp[1];

            if (min[cur] < count) {
                continue;
            }

            for (int[] next : graph[cur]) {
                if (min[next[0]] > next[1] + count) {
                    min[next[0]] = next[1] + count;
                    que.offer(new int[] { next[0], next[1] + count });
                }
            }
        }

        // 3. 출력
        System.out.println(min[N]);
    }
}
