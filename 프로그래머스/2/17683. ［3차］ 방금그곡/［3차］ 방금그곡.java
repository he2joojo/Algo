class Solution {
    public String solution(String m, String[] musicinfos) {

        // 1. 초기 세팅
        m = transSong(m);

        String bestTitle = "(None)";
        int bestTime = -1;

        // 2. 로직
        for (String str : musicinfos) {
            String[] tmp = str.split(",");

            int start = toMin(tmp[0]);
            int end = toMin(tmp[1]);
            int time = end - start;
            String title = tmp[2];
            String melody = playSong(time, tmp[3]);

            if (melody.contains(m)) {
                if (time > bestTime) {
                    bestTitle = title;
                    bestTime = time;
                }
            }
        }

        // 3. 반환
        return bestTitle;
    }

    static int toMin(String str) {

        String[] tmp = str.split(":");

        int h = Integer.parseInt(tmp[0]) * 60;
        int m = Integer.parseInt(tmp[1]);

        return h + m;
    }

    static String playSong(int min, String str) {

        str = transSong(str);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < min; i++) {
            sb.append(str.charAt(i % str.length()));
        }

        return sb.toString();
    }

    static String transSong(String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i + 1) == '#') {
                sb.append(str.toLowerCase().charAt(i));
            } else if (str.charAt(i) != '#') {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
