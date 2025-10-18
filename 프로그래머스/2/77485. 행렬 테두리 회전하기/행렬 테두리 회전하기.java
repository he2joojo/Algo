import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        // 1. 초기 세팅
        int[][] map = new int[rows][columns];
        
        int num = 1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        
        // 2. 로직
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int[] arr  = queries[i];
            
            int x1 = arr[0] - 1;
            int y1 = arr[1] - 1;
            int x2 = arr[2] - 1;
            int y2 = arr[3] - 1;
            
            int tmp = map[x1][y1];
            ans[i] = tmp;
            
            for (int x = x1 + 1; x <= x2; x++) { // 좌측 세로 줄
                map[x - 1][y1] = map[x][y1];
                ans[i] = Math.min(ans[i], map[x][y1]);
            }
            
            for (int y = y1 + 1; y <= y2; y++) { // 아래 가로 줄
                map[x2][y - 1] = map[x2][y];
                ans[i] = Math.min(ans[i], map[x2][y]);
            }
            
            for (int x = x2 - 1; x >= x1; x--) { // 우측 세로 줄
                map[x + 1][y2] = map[x][y2];
                ans[i] = Math.min(ans[i], map[x][y2]);
            }
            
            for (int y = y2 - 1; y >= y1; y--) { // 위 가로 줄
                map[x1][y + 1] = map[x1][y];
                ans[i] = Math.min(ans[i], map[x1][y]);
            }
            
            map[x1][y1 + 1] = tmp;
        }
        
        // 3. 반환
        return ans;
    }
}
