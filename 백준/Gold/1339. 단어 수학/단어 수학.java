import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] arr;

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());

        arr = new int[26];
        String str;
        int k;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            k = (int) Math.pow(10, str.length() - 1);
            for (int j = 0; j < str.length(); j++) {
                int idx = str.charAt(j) - 'A';
                arr[idx] += k;
                k /= 10;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        Arrays.sort(arr);

        int ans = 0;

        for (int i = 0; i < 10; i++) {
            ans += (arr[25 - i] * (9 - i));
        }

        // 3. 출력
        System.out.println(ans);
    }
}