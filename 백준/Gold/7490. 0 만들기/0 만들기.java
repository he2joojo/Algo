import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<String> list;

    public static void main(String[] args) throws IOException {

        // 1. 입력
        int T = Integer.parseInt(br.readLine());

        // 2. 로직
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            dfs(1, "");

            Collections.sort(list);

            for (String str : list) {
                sb.append(str).append("\n");
            }

            sb.append("\n");
        }

        // 3. 출력
        System.out.println(sb);
    }

    static void dfs(int i, String str) {

        if (i == N) {
            if (calculate((str + N).replace(" ", "")) == 0) {
                list.add(str + N);
            }

            return;
        }

        dfs(i + 1, str + i + " ");
        dfs(i + 1, str + i + "+");
        dfs(i + 1, str + i + "-");
    }

    static int calculate(String str) {

        String tmp = "";
        char flag = '+';
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                tmp += str.charAt(i);
                continue;
            }

            if (flag == '+') {
                ans += Integer.parseInt(tmp);
            } else {
                ans -= Integer.parseInt(tmp);
            }
            tmp = "";
            flag = str.charAt(i);
        }

        if (flag == '+') {
            ans += Integer.parseInt(tmp);
        } else {
            ans -= Integer.parseInt(tmp);
        }

        return ans;
    }
}
