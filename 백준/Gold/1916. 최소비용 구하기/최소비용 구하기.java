import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static int m;
	static List<List<Node>> graph;
	static int[] dist;
	static int start;
	static int dest;

	static void input() throws IOException {

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()))
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		st = new StringTokenizer(br.readLine());

		start = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());

		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		dijkstra();

		// 3. 출력
		System.out.println(dist[dest]);
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		Node node;

		while (!pq.isEmpty()) {
			node = pq.poll();

			if (dist[node.idx] < node.cost) { // 이미 경로 정해진 노드
				continue;
			}

			for (Node next : graph.get(node.idx)) { // 연결된 경로 비용 갱신
				if (dist[next.idx] > dist[node.idx] + next.cost) {
					dist[next.idx] = dist[node.idx] + next.cost;
					next.cost = dist[node.idx] + next.cost;
					pq.offer(next);
				}
			}
		}
	}
}

class Node implements Comparable<Node> {

	int idx;
	int cost;

	public Node(int idx, int cost) {
		super();
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}