import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        // 1. 초기 세팅
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        // 2. 로직
        List<Integer> elementsA = getElements(arrayA[0]);
        List<Integer> elementsB = getElements(arrayB[0]);

        int ans = 0;

        for (int k : elementsA) {
            if (check(k, arrayA, arrayB)) {
                ans = k;
                break;
            }
        }

        for (int k : elementsB) {
            if (k < ans)
                break;

            if (check(k, arrayB, arrayA)) {
                ans = Math.max(ans, k);
            }
        }

        // 3. 반환
        return ans;
    }

    static List<Integer> getElements(int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = n; i > 1; i--) {
            if (n % i == 0)
                list.add(i);
        }

        return list;
    }

    static boolean check(int n, int[] arrayA, int[] arrayB) {

        for (int k : arrayA) {
            if (k % n != 0)
                return false;
        }

        for (int k : arrayB) {
            if (k % n == 0)
                return false;
        }

        return true;
    }
}
