import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int v;
	static Node[] graph;
	static int max;

	static void input() throws IOException {

		v = Integer.parseInt(br.readLine());

		graph = new Node[v + 1];

		for (int i = 1; i <= v; i++) {
			graph[i] = new Node();
			graph[i].childs = new ArrayList<>();
		}

		int idx;
		int child;
		int weight;

		for (int i = 0; i < v - 1; i++) {
			st = new StringTokenizer(br.readLine());
			idx = Integer.parseInt(st.nextToken());
			child = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			graph[idx].childs.add(graph[child]);
			graph[child].weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		getRadius(graph[1]);

		// 3. 출력
		System.out.println(max);
	}

	static int getRadius(Node node) {
		List<Integer> sum = new ArrayList<>();

		for (int i = 0; i < node.childs.size(); i++) {
			sum.add(getRadius(node.childs.get(i)));
		}

		// 가장 큰 값 2개 꺼내기
		Collections.sort(sum, Collections.reverseOrder());

		int left = 0;
		int right = 0;

		if (sum.size() > 0) {
			left = sum.get(0);
		}
		if (sum.size() > 1) {
			right = sum.get(1);
		}

		max = Math.max(max, left + right);

		// 둘 중 큰 쪽을 반환
		return Math.max(left + node.weight, right + node.weight);
	}
}

class Node {

	List<Node> childs;
	int weight;
}