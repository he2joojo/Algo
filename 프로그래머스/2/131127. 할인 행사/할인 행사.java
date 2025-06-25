import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		// 1. 구매 목록 map에 저장
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			map.put(want[i], i);
		}

		// 2. 0-9 담고 확인
		for (int i = 0; i < 10; i++) {
			if (map.containsKey(discount[i])) {
				int idx = map.get(discount[i]);
				number[idx]--;
			}
		}

		if (check(number)) {
			answer++;
		}

		// 3. 2일부터 검사
		String str;
		int idx;

		for (int start = 1; start + 10 <= discount.length; start++) {
			// 전날 항목 제거
			str = discount[start - 1];

			if (map.containsKey(str)) {
				idx = map.get(str);
				number[idx]++;
			}

			// 새 항목 추가
			str = discount[start + 9];

			if (map.containsKey(str)) {
				idx = map.get(str);
				number[idx]--;
			}

			// 검사
			if (check(number)) {
				answer++;
			}
		}

		return answer;
	}

	static boolean check(int[] number) {
		for (int i : number) {
			if (i > 0) {
				return false;
			}
		}
		return true;
	}
}
