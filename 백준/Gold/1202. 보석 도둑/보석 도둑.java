import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n; // 보석 개수
	static int k; // 가방 개수
	static PriorityQueue<Jewelry> all; // 모든 보석(무게 오름차순)
	static PriorityQueue<Jewelry> checked; // 가방에 담을 수 있는게 확인된 보석(가격 내림차순)
	static PriorityQueue<Integer> bags;

	static void input() throws IOException {

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		all = new PriorityQueue<>(Comparator.comparingInt(j -> j.weight));
		checked = new PriorityQueue<>(Comparator.comparingInt(j -> -j.value));

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			all.offer(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		bags = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			bags.offer(Integer.parseInt(br.readLine()));
		}
	}

	public static void main(String[] args) throws IOException {

		// 1. 입력 및 초기화
		input();

		// 2. 로직
		long ans = 0;
		int c;

		for (int i = 0; i < k; i++) { // 가방 오름차순 순회
			c = bags.poll();
			while (!all.isEmpty() && all.peek().weight <= c) {
				checked.offer(all.poll());
			}
			if (!checked.isEmpty()) {
				ans += checked.poll().value;
			}
		}

		// 3. 출력
		System.out.println(ans);
	}
}

class Jewelry {

	int weight;
	int value;

	public Jewelry(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}