package Neetcode_450_Questions.HARD;

/*
Solution : https://leetcode.com/problems/stickers-to-spell-word/solutions/5088354/java-bfs-with-frequency-match/

Question : https://leetcode.com/problems/stickers-to-spell-word/description/
*/
import java.util.*;

public class StickersToSpellWord_LC691 {
    public int minStickers(String[] stickers, String target) {

        Deque<String> deque = new LinkedList<>(); // [thehat]
        deque.add(target);

        Set<String> visited = new HashSet<>();
        visited.add(target);

        // Since we have 'a' -> 'z' => [0 -> 25]
        Set<Sticker> setStickers = new HashSet<>();
        for (String stickerStr : stickers) {
            setStickers.add(new Sticker(stickerStr));
        }

        int steps = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            steps += 1;
            for (int i = 0; i < size; i++) {
                String targetStr = deque.poll();

                for (Sticker sticker : setStickers) {
                    int[] targetHash = new int[26];
                    StringBuilder remainder = new StringBuilder();

                    for (char ch : targetStr.toCharArray()) {
                        int idx = ch - 'a';
                        if (sticker.stickerHash[idx] > targetHash[idx]) {
                            targetHash[idx]++;
                        } else {
                            remainder.append(ch);
                        }
                    }

                    // empty string, all target characters found
                    if (remainder.isEmpty()) {
                        return steps;
                    }

                    // ehat -> ea -> ""
                    if (!visited.contains(remainder.toString())) {
                        deque.add(remainder.toString());
                        visited.add(remainder.toString());
                    }

                }
            }
        }
        return -1;

    }

    class Sticker {
        public int[] stickerHash;

        Sticker(String stickerStr) {
            stickerHash = new int[26];
            for (char ch : stickerStr.toCharArray()) {
                stickerHash[ch - 'a']++;
            }
        }

    }
}
