import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int count = 0;
        int p1 = 0;
        int p2 = people.length - 1;

        while (p1 <= p2) {
            if (people[p2] + people[p1] <= limit) {
                p1++;
                p2--;
                count++;
            } else {
                p2--;
                count++;
            }
        }

        return count;
    }
}
