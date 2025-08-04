import java.util.ArrayList;
import java.util.List;

class Solution {

    static String[] alpha = { "A", "E", "I", "O", "U" };
    static List<String> words;

    public int solution(String word) {
        words = new ArrayList<>();
        dfs("");
        
        int answer = words.indexOf(word) + 1;
        return answer;
    }

    static void dfs(String str) {
        if (!str.equals("")) {
            words.add(str);
        }

        if (str.length() >= 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(str + alpha[i]);
        }
    }
}
