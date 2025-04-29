import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] buildings;

    static int ans;

    static void input() throws IOException {

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        buildings = new int[N];

        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력
        input();

        // 2. 로직
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            double slope = 0;

            for (int j = i - 1; j >= 0; j--) { // 좌측 검사
                double tmp = (double) (buildings[i] - buildings[j]) / (i - j);
                if (j == i - 1 || slope > tmp) {
                    cnt++;
                    slope = tmp;
                }
            }

            for (int j = i + 1; j < N; j++) { // 우측 검사
                double tmp = (double) (buildings[j] - buildings[i]) / (j - i);
                if (j == i + 1 || slope < tmp) {
                    cnt++;
                    slope = tmp;
                }
            }

            ans = Math.max(ans, cnt);
        }

        // 3. 출력
        System.out.println(ans);
    }
}
