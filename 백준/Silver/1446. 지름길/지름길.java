import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int D;

    static List<int[]>[] ways; // i까지 가는 방법, 비용
    static int[] distance;

    public static void main(String[] args) throws IOException {

        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        ways = new ArrayList[D + 1];
        distance = new int[D + 1];

        for (int i = 1; i <= D; i++) {
            distance[i] = i;
            ways[i] = new ArrayList<>();
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (to > D || (to - from) <= cost) { // 도착지를 넘어가거나 or 지름길이 더 긴 경우
                continue;
            }

            ways[to].add(new int[]{from, cost});
        }

        // 2. 로직

        for (int i = 1; i <= D; i++) {
            distance[i] = distance[i - 1] + 1;

            for (int j = 0; j < ways[i].size(); j++) {
                int from = ways[i].get(j)[0];
                int cost = ways[i].get(j)[1];

                distance[i] = Math.min(distance[i], distance[from] + cost);
            }
        }

        // 3. 출력
        System.out.println(distance[D]);
    }
}
