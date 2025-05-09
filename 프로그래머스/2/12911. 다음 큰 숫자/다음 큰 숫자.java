class Solution {
    public int solution(int n) {

        int bitCnt = Integer.bitCount(n);
        int next = n + 1;

        while (Integer.bitCount(next) != bitCnt) {
            next++;
        }
        
        return next;
    }
}
