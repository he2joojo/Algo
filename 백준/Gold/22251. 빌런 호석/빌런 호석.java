import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N; // 빌등 층 수
    static int K; // 디스플레이 자리 수
    static int P; // 반전시킬 개수
    static int X; // 현재 층

    static int[] numbers = {
            0b1110111, // 0
            0b0010010, // 1
            0b1011101, // 2
            0b1011011, // 3
            0b0111010, // 4
            0b1101011, // 5
            0b1101111, // 6
            0b1010010, // 7
            0b1111111, // 8
            0b1111011, // 9
    };

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

    }

    public static void main(String[] args) throws IOException {

        // 1. 입력
        input();

        // 2. 로직
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }

            if (change(i) <= P) {
                count++;
            }
        }

        // 3. 출력
        System.out.println(count);
    }

    static int change(int from) {
        int total = 0;
        int to = X;

        for (int i = 0; i < K; i++) {
            int diff = numbers[from % 10] ^ numbers[to % 10];
            total += Integer.bitCount(diff);

            from /= 10;
            to /= 10;
        }

        return total;
    }
}
