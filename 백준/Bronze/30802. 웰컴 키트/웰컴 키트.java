import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] arr;
    static int t;
    static int p;
    static final int SIZE = 6;

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        int tCount = 0;

        for (int i = 0; i < SIZE; i++) {
            tCount += (arr[i] / t);
            if (arr[i] % t != 0) {
                tCount++;
            }
        }

        // 3. 출력
        System.out.println(tCount);
        System.out.println((n / p) + " " + (n % p));
    }
}