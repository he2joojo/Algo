class Solution {
    public String solution(String s) {

        String arr[]  = s.split(" ");

        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int tmp = Integer.parseInt(arr[i]);

            if (min > tmp) {
                min = tmp;
            } else if (max < tmp) {
                max = tmp;
            }
        }

        String answer = min + " " + max;
        return answer;
    }
}
