import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int[][] graph;
    static List<int[]> cctvs;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][][] directions = {
            {},
            { { 0 }, { 1 }, { 2 }, { 3 } },
            { { 0, 1 }, { 2, 3 } },
            { { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } },
            { { 0, 1, 2 }, { 0, 1, 3 }, { 0, 2, 3 }, { 1, 2, 3 } },
            { { 0, 1, 2, 3 } }
    };
    static int ans;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        cctvs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (0 < graph[i][j] && graph[i][j] < 6) {
                    cctvs.add(new int[] { i, j });
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        ans = Integer.MAX_VALUE;
        dfs(0, graph);

        // 3. 출력
        System.out.println(ans);
    }

    static void dfs(int idx, int[][] board) {
        if (idx == cctvs.size()) {
            ans = Math.min(ans, countBlind(board));
            return;
        }

        int[] cctv = cctvs.get(idx);
        int r = cctv[0];
        int c = cctv[1];
        int type = graph[r][c];

        for (int[] dir : directions[type]) {
            int[][] copied = copyBoard(board);
            for (int d : dir) {
                int nr = r;
                int nc = c;
                while (true) {
                    nr += dx[d];
                    nc += dy[d];

                    if (!isValid(nr, nc) || board[nr][nc] == 6)
                        break;
                    if (copied[nr][nc] == 0) {
                        copied[nr][nc] = 7;
                    }
                }
            }
            dfs(idx + 1, copied);
        }
    }

    static int countBlind(int[][] board) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, M);
        }

        return newBoard;
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
