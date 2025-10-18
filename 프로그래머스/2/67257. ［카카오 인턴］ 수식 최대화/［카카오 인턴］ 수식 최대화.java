import java.util.*;

class Solution {
    public long solution(String expression) {

        // 1. 초기 세팅
        char[][] comb = {
                { '+', '-', '*' },
                { '+', '*', '-' },
                { '-', '+', '*' },
                { '-', '*', '+' },
                { '*', '+', '-' },
                { '*', '-', '+' }
        };

        List<Long> nums = new ArrayList<>();
        List<Character> exs = new ArrayList<>();

        String tmp = "";

        for (char ch : expression.toCharArray()) {
            if ('0' <= ch && ch <= '9') {
                tmp += ch;
            } else {
                nums.add(Long.parseLong(tmp));
                exs.add(ch);
                tmp = "";
            }
        }

        nums.add(Long.parseLong(tmp));

        // 2. 로직
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < comb.length; i++) {

            List<Long> numsClone = new ArrayList<>(nums);
            List<Character> exsClone = new ArrayList<>(exs);

            for (char ex : comb[i]) { // 수식 하나씩 계산

                for (int j = 0; j < exsClone.size(); j++) {
                    if (exsClone.get(j) != ex)
                        continue;

                    long num1 = numsClone.get(j);
                    long num2 = numsClone.get(j + 1);

                    long result = 0L;

                    if (ex == '+') {
                        result = num1 + num2;
                    } else if (ex == '-') {
                        result = num1 - num2;
                    } else {
                        result = num1 * num2;
                    }

                    numsClone.set(j, result);

                    numsClone.remove(j + 1);
                    exsClone.remove(j);

                    j--;
                }
            }

            list.add(Math.abs(numsClone.get(0)));
        }

        // 3. 반환
        Collections.sort(list, Collections.reverseOrder());

        return list.get(0);
    }
}
