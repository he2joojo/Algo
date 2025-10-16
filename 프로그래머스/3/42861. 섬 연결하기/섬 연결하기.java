import java.util.Arrays;

class Solution {

    static int[] p;

    public int solution(int n, int[][] costs) {

        // 1. 초기 세팅
        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];
        });

        p = new int[n + 1];

        for (int i = 1; i <= n; i++)
            p[i] = i;

        // 2. 로직
        int cnt = 0;
        int sum = 0;

        for (int[] tmp : costs) {
            int a = tmp[0];
            int b = tmp[1];
            int cost = tmp[2];

            if (find(a) != find(b)) {
                cnt++;
                sum += cost;
                union(a, b);
            }

            if (cnt == n - 1)
                break;
        }

        // 3. 반환
        return sum;
    }

    static int find(int k) {
        if (p[k] == k)
            return k;
        return find(p[k]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb)
            p[pa] = pb;
    }
}
