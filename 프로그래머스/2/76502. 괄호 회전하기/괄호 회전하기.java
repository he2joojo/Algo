import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
	public int solution(String s) {
		StringBuilder sb = new StringBuilder(s);
		int answer = 0;

		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');

		for (int i = 0; i < s.length(); i++) {
			// 1. 문자열 검사
			if (check(sb, map)) {
				answer++;
			}

			char ch = sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(ch);
		}

		return answer;
	}

	static boolean check(StringBuilder sb, Map<Character, Character> map) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);

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
