import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // 1. 입력
        int N = Integer.parseInt(br.readLine());

        // 2. 로직
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int newHeight = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > newHeight) {
                count++;
                stack.pop();
            }

            if (stack.isEmpty() || newHeight > stack.peek()) {
                if (newHeight > 0) {
                    stack.push(newHeight);
                }
            }
        }

        count += stack.size();

        // 3. 출력
        System.out.println(count);
    }
}
