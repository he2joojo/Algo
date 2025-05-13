import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        list.add(words[0]);
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (lose(list, words[i]) || set.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            list.add(words[i]);
            set.add(words[i]);
        }

        return answer;
    }

    static boolean lose(List<String> list, String str) {
        String before = list.get(list.size() - 1);
        return before.charAt(before.length() - 1) != str.charAt(0);
    }
}