import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		Stack<Character> st;
		String str;
		char ch;

		out: while (!".".equals((str = br.readLine()))) {
			// 2. 로직
			st = new Stack();

			for (int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				switch (ch) {
				case '(':
				case '[':
					st.add(ch);
					break;
				case ')':
					if (st.isEmpty() || st.pop() != '(') {
						sb.append("no").append("\n");
						continue out;
					}
					break;
				case ']':
					if (st.isEmpty() || st.pop() != '[') {
						sb.append("no").append("\n");
						continue out;
					}
				}
			}
			if (st.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		// 3. 출력
		System.out.println(sb.toString());
	}
}