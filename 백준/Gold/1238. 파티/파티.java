import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int X;
    static List<List<int[]>> graph;
    static List<List<int[]>> reverseGraph;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new int[] { to, cost });
            reverseGraph.get(to).add(new int[] { from, cost });
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        int[] fromX = dijkstra(graph, X);
        int[] toX = dijkstra(reverseGraph, X);

        // 3. 출력
        int max = 0;

        for (int i = 1; i <= N; i++) {
            if (fromX[i] == Integer.MAX_VALUE || toX[i] == Integer.MAX_VALUE)
                continue;
            max = Math.max(max, fromX[i] + toX[i]);
        }

        System.out.println(max);
    }

    static int[] dijkstra(List<List<int[]>> g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.offer(new int[] { start, 0 });
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int cur = tmp[0];
            int cost = tmp[1];

            for (int[] next : g.get(cur)) {
                int to = next[0];
                int weight = next[1];
                if (dist[to] > cost + weight) {
                    dist[to] = cost + weight;
                    pq.offer(new int[] { to, dist[to] });
                }
            }
        }

        return dist;
    }
}
