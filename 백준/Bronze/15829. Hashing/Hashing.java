import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        BigInteger r = BigInteger.valueOf(31);
        BigInteger m = BigInteger.valueOf(1234567891);

        // 2. 로직
        BigInteger ans = BigInteger.valueOf(0);

        for (int i = 0; i < n; i++) {
            BigInteger tmp = BigInteger.valueOf(str.charAt(i) - 'a' + 1);
            tmp = tmp.multiply(r.pow(i));
            tmp = tmp.mod(m);
            ans = ans.add(tmp);
        }

        // 3. 출력
        System.out.println(ans.mod(m));
    }
}