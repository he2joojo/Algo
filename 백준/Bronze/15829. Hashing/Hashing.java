import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        final int R = 31;
        final int M = 1234567891;

        // 2. 로직
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += (str.charAt(i) - 'a' + 1) * Math.pow(R, i);
        }

        // 3. 출력
        System.out.println(ans % M);
    }
}