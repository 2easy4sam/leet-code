package com.leetcode.questions.backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {
    private Queue<Combo> q;

    public CombinationIterator(String characters, int combinationLength) {
        // use bfs, starting with an empty string
        // append one char at a time until combinationLength is reached
        q = new LinkedList<>();
        q.offer(new Combo("", characters));

        while (!q.isEmpty() && q.peek().combo.length() != combinationLength) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Combo top = q.poll();
                String chars = top.chars;

                for (int j = 0; j < chars.length(); j++) {
                    StringBuilder sb = new StringBuilder(top.combo);
                    q.offer(new Combo(sb.append(chars.charAt(j)).toString(), chars.substring(j + 1)));
                }
            }
        }
    }

    public String next() {
        return q.poll().combo;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    private static class Combo {
        String combo;
        String chars;

        Combo(String combo, String chars) {
            this.combo = combo;
            this.chars = chars;
        }
    }
}
