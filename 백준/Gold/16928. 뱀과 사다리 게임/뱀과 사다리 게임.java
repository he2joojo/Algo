import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;

    static Map<Integer, Integer> map;
    static int ans;

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.put(a, b);
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력
        input();

        // 2. 로직
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {1, 0});

        boolean[] visited = new boolean[101];
        visited[1] = true;

        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int now = tmp[0];
            int count = tmp[1];

            if (now >= 100) {
                ans = count;
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                
                if (next > 100 || visited[next]) continue;

                if (map.containsKey(next)) {
                    next = map.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    que.offer(new int[] {next, count + 1});
                }
            }
        }

        // 3. 출력
        System.out.println(ans);
    }
}
