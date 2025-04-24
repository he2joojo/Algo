import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int K;
    static int L;

    static int[][] graph;
    static Deque<int[]> move;
    static Deque<int[]> snake;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int time;
    static int dir;

    static void input() throws IOException {

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i = 0; i < K; i++) { // 사과 위치 저장
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            graph[r][c] = 1;
        }

        L = Integer.parseInt(br.readLine());
        move = new ArrayDeque<>();

        for (int i = 0; i < L; i++) { // 방향 정보 저장

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = "L".equals(st.nextToken()) ? 0 : 1; 

            move.add(new int[] {a, b});
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력
        input();

        // 2. 로직
        snake = new ArrayDeque<>();
        time = 0;
        dir = 3; // 우측

        graph[0][0] = 2;
        snake.add(new int[] {0, 0});

        while (true) {
            time++;

            // 방향 전환
            if (!move.isEmpty() && time > move.peekFirst()[0]) {
                changeDir(move.pollFirst()[1]);
            }

            // 머리 이동
            move();

            // 벽에 부딪혔는지 확인
            int r = snake.peekFirst()[0];
            int c = snake.peekFirst()[1];

            if (!isValid(r, c)) {
                break;
            }

            // 몸에 부딪혔는지 확인
            if (graph[r][c] == 2) {
                break;
            }

            // 사과없으면 꼬리 이동
            if (graph[r][c] != 1) {
                int[] tail = snake.pollLast();
                graph[tail[0]][tail[1]] = 0;
            }

            graph[r][c] = 2;
        }

        // 3. 출력
        System.out.println(time);
    }

    static void changeDir(int d) {
        if (dir == 0) {
            dir = (d == 0) ? 2 : 3;
        } else if (dir == 1) {
            dir = (d == 0) ? 3 : 2;
        } else if (dir == 2) {
            dir = (d == 0) ? 1 : 0;
        } else {
            dir = (d == 0) ? 0 : 1;
        }
    }

    static void move() {
        int r = snake.peekFirst()[0];
        int c = snake.peekFirst()[1];

        r += direction[dir][0];
        c += direction[dir][1];

        snake.addFirst(new int[] {r, c});
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N; 
    }
}
