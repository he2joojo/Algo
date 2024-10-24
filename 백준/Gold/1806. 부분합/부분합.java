import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int s;
    static int sum;
    static int[] arr;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        if (sum < s) {
            System.out.println(0);
            return;
        } else if (sum == s) {
            System.out.println(n);
            return;
        }

        int tmp = 0;
        int f = 0; // 앞 포인터
        int b = 0; // 뒤 포인터
        int ans = n + 1;

        while (f < n && b < n) {
            while (tmp < s && b < n) {
                tmp += arr[b++];
            }
            while (tmp >= s && f < n) {
                tmp -= arr[f++];
            }
            ans = Math.min(ans, b - f + 1);
        }

        // 3. 출력
        System.out.println(ans);
    }
}