import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] arr;
    static int[] lis;

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++) { // 누적합 계산
            arr[i] = Integer.parseInt(br.readLine());
        }

        lis = new int[n];
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 및 초기화
        input();

        // 2. 로직
        int max;

        for (int i = 1; i < n; i++) { // arr 각 요소 순회
            max = -1;
            for (int j = 0; j < i; j++) { // 앞 요소 순회
                if (arr[i] > arr[j]) {
                    max = Math.max(max, lis[j]);
                }
            }
            lis[i] = max + 1;
        }

        max = 0;

        for (int i = 0; i < n; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }

        // 3. 출력
        System.out.println(n - max - 1);
    }
}