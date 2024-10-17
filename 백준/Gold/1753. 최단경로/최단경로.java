import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int v;
	static int e;
	static int k; // 시작 정점
	static List<List<Node>> graph;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	static void input() throws IOException {

		st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		k = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();

		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()))
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		dist = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			dist[i] = INF;
		}
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		dijkstra();

		// 3. 출력
		for (int i = 1; i <= v; i++) {
			if (dist[i] == INF) {
				sb.append("INF").append("\n");
				continue;
			}
			sb.append(dist[i]).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(k, 0));
		dist[k] = 0;
		Node node;
		int tmp;

		while (!pq.isEmpty()) {
			node = pq.poll();

			if (dist[node.num] < node.w) { // 이미 처리한 노드인지 확인
				continue;
			}

			for (Node next : graph.get(node.num)) { // 연결된 노드 순회
				tmp = dist[node.num] + next.w;
				if (tmp < dist[next.num]) { // 새로운 최단경로를 찾았다면
					dist[next.num] = tmp;
					next.w = tmp;
					pq.offer(next);
				}
			}
		}
	}
}

class Node implements Comparable<Node> {

	int num;
	int w;

	public Node(int num, int w) {
		this.num = num;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}