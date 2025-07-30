class Solution {

    static int[][] result;

    public int solution(int[][] triangle) {
        result = new int[triangle.length][triangle.length];

        return dfs(0, 0, triangle.length, triangle);
    }

    static int dfs(int r, int c, int n, int[][] triangle) {
        if (r == n - 1) {
            return triangle[r][c];
        }

        int left = result[r + 1][c];
        if (left == 0) {
            left = dfs(r + 1, c, n, triangle);
            result[r + 1][c] = left;
        }

        int right = result[r + 1][c + 1];
        if (right == 0) {
            right = dfs(r + 1, c + 1, n, triangle);
            result[r + 1][c + 1] = right;
        }

        return result[r][c] = triangle[r][c] + Math.max(left, right);
    }
}
