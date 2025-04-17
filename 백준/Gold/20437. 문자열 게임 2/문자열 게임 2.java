import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

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

            for (int j = 0; j < 26; j++) {
                index.put((char)(j + 'a'), new ArrayDeque<>());
            }

            for (int j = 0; j < w.length(); j++) {
                char ch = w.charAt(j);
                Deque<Integer> dq = index.get(ch);
                dq.addLast(j);

                // k개 이상일 때는 맨 앞 하나씩 제거 (슬라이딩 윈도우 유지)
                if (dq.size() >= k) {
                    int start = dq.peekFirst();
                    int end = j;
                    int len = end - start + 1;

                    min = Math.min(min, len);
                    max = Math.max(max, len);

                    // 다음 탐색 위해 앞 하나 제거
                    dq.pollFirst();
                }
            }

            if (min == 10001 || max == 0) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
