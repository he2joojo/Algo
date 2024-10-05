import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] arr;
    static int[] lis;
    static int[] lds;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis = new int[n];
        lds = new int[n];
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        int max;

        for (int i = 0; i < n; i++) { // 증가하는 수열 길이 찾기
            lis[i] = 1;
            max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, lis[j]);
                }
            }
            lis[i] += max;
        }

        for (int i = n - 1; i >= 0; i--) { // 감소하는 수열 길이 찾기
            lds[i] = 1;
            max = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, lds[j]);
                }
            }
            lds[i] += max;
        }

        // 3. 출력
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, lis[i] + lds[i] - 1);
        }

        System.out.println(ans);
    }
}