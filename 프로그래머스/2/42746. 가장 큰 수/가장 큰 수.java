import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {

        // 1. 초기 세팅
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2. 로직
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) {
            return "0";
        }

        // 3. 반환
        StringBuilder sb = new StringBuilder();

        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString();
    }
}