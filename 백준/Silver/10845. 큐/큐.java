import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque();

		// 2. 로직
		String str;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			
			switch(str) {
			case "push":
				deque.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.pollFirst());
				}
				sb.append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if (deque.isEmpty()) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append("\n");
				break;
			case "front":
				if (deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.peekFirst());
				}
				sb.append("\n");
				break;
			case "back":
				if (deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.peekLast());
				}
				sb.append("\n");
			}
		}

		// 3. 출력
		System.out.println(sb.toString());
	}
}