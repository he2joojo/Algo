import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int r = 5;
        int c = 5;
        Set<String> set = new HashSet<>();

        for (char ch : dirs.toCharArray()) {
            int nr = r;
            int nc = c;

            switch (ch) {
                case 'U':
                    nr--;
                    break;
                case 'D':
                    nr++;
                    break;
                case 'R':
                    nc++;
                    break;
                case 'L':
                    nc--;
                    break;
            }

            if (!isValid(nr, nc))
                continue;

            set.add(r + "," + c + "," + nr + "," + nc);
            set.add(nr + "," + nc + "," + r + "," + c);

            r = nr;
            c = nc;
        }

        return set.size() / 2;
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < 11 && 0 <= c && c < 11;
    }
}
