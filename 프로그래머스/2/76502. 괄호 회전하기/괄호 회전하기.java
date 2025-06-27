import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Solution {

	static Map<Character, Character> map;

	public int solution(String s) {

		Queue<Character> que = new ArrayDeque<>();
		for (char ch : s.toCharArray())
			que.offer(ch);

		map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');

		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			// 1. 문자열 검사
			if (check(que)) {
				answer++;
			}

			// 2. 회전
			que.offer(que.poll());
		}

		return answer;
	}

	static boolean check(Queue<Character> que) {
		Stack<Character> st = new Stack<>();

		for (char ch : que) {

			if (!map.containsKey(ch)) { // 여는 괄호라면
				st.push(ch);
				continue;
			}

			// 닫는 괄호라면
			if (st.isEmpty() || st.pop() != map.get(ch)) {
				return false;
			}
		}

		return st.isEmpty();
	}
}
