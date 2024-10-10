import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        int n = 0;
        int idx = 0;

        for (int i = 0; i < 3; i++) {
            str = br.readLine();
            if ('0' <= str.charAt(0) && str.charAt(0) <= '9') {
                n = Integer.parseInt(str);
                idx = i;
                break;
            }
        }

        // 2. 로직
        // 3. 출력
        n += (3 - idx);

        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (n % 3 == 0) {
            System.out.println("Fizz");
        } else if (n % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(n);
        }
    }
}