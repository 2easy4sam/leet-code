package com.leetcode.questions.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Set<String> combos = new HashSet<>();
        combos.add(tiles);
        // bfs
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair("", tiles));

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                String key = pair.key;
                String value = pair.value;
                int n = value.length();

                for (int j = 0; j < n; j++) {
                    String part1 = value.substring(0, j);
                    String part2 = value.substring(j + 1, n);
                    String newValue = part1 + part2;

                    String combo = key + value.charAt(j);
                    combos.add(combo);
                    if (!newValue.isEmpty()) q.offer(new Pair(combo, newValue));
                }
            }
        }

        return combos.size();
    }

    private static class Pair {
        String key;
        String value;

        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
