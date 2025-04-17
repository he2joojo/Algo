import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // 1. 입력
        int T = Integer.parseInt(br.readLine());

        // 2. 로직
        for (int i = 0; i < T; i++) {
            String w = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());

            if (k == 1) {
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            int min = 10001;
            int max = 0;

            Map<Character, Deque<Integer>> index = new HashMap<>();

            for (int j = 0; j < 26; j++) { // 초기화
                index.put((char) (j + 'a'), new ArrayDeque<>());
            }

            for (int j = 0; j < w.length(); j++) { // w 순회
                char ch = w.charAt(j);
                Deque<Integer> dp = index.get(ch);
                dp.addLast(j);

                if (dp.size() == k) {
                    int start = dp.peekFirst();
                    int end = j;
                    int len = end - start + 1;

                    min = Math.min(min, len);
                    max = Math.max(max, len);
                    
                    dp.pollFirst();
                }

            }

            if (min == 10001 || max == 0) { // 답 구하기
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }

        // 3. 출력
        System.out.print(sb.toString());
    }
}
