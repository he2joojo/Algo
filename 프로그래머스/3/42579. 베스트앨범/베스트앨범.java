import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 1. 초기 세팅
        Map<String, Integer> topGenres = new HashMap<>();
        Map<String, PriorityQueue<Song>> topSongs = new HashMap<>();

        // 2. 로직
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];

            topGenres.put(g, topGenres.getOrDefault(g, 0) + plays[i]);

            if (!topSongs.containsKey(g)) {
                topSongs.put(g, new PriorityQueue<>());
            }

            topSongs.get(g).add(new Song(i, plays[i]));
        }

        List<String> genre = new ArrayList<>(topGenres.keySet());
        Collections.sort(genre, (a, b) -> topGenres.get(b) - topGenres.get(a));

        List<Integer> list = new ArrayList<>();

        for (String g : genre) {
            PriorityQueue<Song> pq = topSongs.get(g);

            for (int i = 0; i < 2; i++) {
                if (!pq.isEmpty()) {
                    list.add(pq.poll().idx);
                }
            }
        }

        // 3. 반환
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}

class Song implements Comparable<Song> {
    int idx;
    int playCnt;

    Song(int idx, int playCnt) {
        this.idx = idx;
        this.playCnt = playCnt;
    }

    @Override
    public int compareTo(Song o) {

        if (this.playCnt == o.playCnt) {
            return this.idx - o.idx;
        }

        return o.playCnt - this.playCnt;
    }
}
