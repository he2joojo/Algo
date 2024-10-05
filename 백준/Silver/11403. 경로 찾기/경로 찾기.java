import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static boolean[][] graph;
    static boolean[][] visited;
    static int m;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        graph = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if ("1".equals(st.nextToken())) {
                    graph[i][j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        for (int i = 0; i < n; i++) {
            m = i;
            visited = new boolean[n][n];
            dfs(i);
        }

        // 3. 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j]) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int k) {
        for (int i = 0; i < n; i++) {
            if (graph[k][i] && !visited[k][i]) {
                graph[m][i] = true;
                visited[k][i] = true;
                dfs(i);
            }
        }
    }
}