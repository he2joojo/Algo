import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int[] elements) {

		// 1. 수열 2배로 늘리기
		int n = elements.length;
		int[] doubleElements = new int[n * 2];

		for (int i = 0; i < n; i++) {
			doubleElements[i] = elements[i];
			doubleElements[i + n] = elements[i];
		}

		// 2. 1 ~ n개 조합 더하기
		Set<Integer> set = new HashSet<>();

		for (int k = 1; k <= n; k++) {
			for (int start = 0; start < n; start++) {
				int sum = 0;
				for (int i = 0; i < k; i++) {
					sum += doubleElements[start + i];
				}
				set.add(sum);
			}
		}

		return set.size();
	}
}
