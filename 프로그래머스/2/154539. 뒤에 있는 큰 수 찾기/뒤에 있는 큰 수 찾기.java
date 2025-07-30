import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> st = new Stack<>();
        int n = numbers.length;
        int[] answer = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int now = numbers[i];

            while (!st.isEmpty() && st.peek() <= now) {
                st.pop();
            }

            if (st.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = st.peek();
            }

            st.add(now);
        }

        return answer;
    }
}
