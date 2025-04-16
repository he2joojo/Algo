import java.util.Scanner;

public class Main {

    static int N;
    static String input;

    static int rCount;
    static int rSeq;
    static int bCount;
    static int bSeq;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        input = sc.nextLine();
    }

    public static void main(String[] args) {

        // 1. 입력
        input();

        // 2. 로직
        //
        char ch = input.charAt(0); // 왼쪽 끝 개수 세기
        int tmp = 1;

        for (int i = 1; i < N; i++) {
            if (input.charAt(i) == ch) {
                tmp++;
                continue;
            }
            break;
        }

        if (ch == 'R') {
            rSeq = tmp;
        } else {
            bSeq = tmp;
        }

        ch = input.charAt(N - 1); // 오른쪽 끝 개수 세기
        tmp = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (input.charAt(i) == ch) {
                tmp++;
                continue;
            }
            break;
        }

        if (ch == 'R') {
            rSeq = Math.max(rSeq, tmp);
        } else {
            bSeq = Math.max(bSeq, tmp);
        }

        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'R') {
                rCount++;
            } else {
                bCount++;
            }
        }

        int result = Math.min(rCount - rSeq, bCount - bSeq);

        // 3. 출력
        System.out.println(result);
    }
}
