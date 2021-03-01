package com.leetcode.questions.string;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        /*
        - BFS with a queue for keeping track of beginning indexes of words
        - DFS for building all combos
        */

        Set<String> dict = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        /*
        end index is the start index of another word
        */
        Map<Integer, List<Integer>> map = new HashMap<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int startIndex = q.poll();
            List<Integer> endIndexes = new ArrayList<>();

            for (int i = startIndex; i <= s.length(); i++) {
                if (dict.contains(s.substring(startIndex, i))) {
                    endIndexes.add(i);
                    if (i < s.length()) q.offer(i);
                }
            }

            if (endIndexes.isEmpty()) return Collections.emptyList();
            map.put(startIndex, endIndexes);
        }

        // build all combos using DFS
        dfs(s, 0, map, new LinkedList<>(), res);

        return res;
    }

    private void dfs(String s, int startIndex, Map<Integer, List<Integer>> map, List<String> sentence, List<String> res) {
        List<Integer> endIndexes = map.get(startIndex);

        if (endIndexes != null) {
            for (int i = 0; i < endIndexes.size(); i++) {
                sentence.add(s.substring(startIndex, endIndexes.get(i)));
                dfs(s, endIndexes.get(i), map, sentence, res);
                if (sentence.size() > 0 && i < endIndexes.size()) {
                    sentence.remove(sentence.size() - 1);
                }
            }
        } else {
            // reached the end
            StringBuilder sb = new StringBuilder();

            for (String word : sentence) {
                sb.append(word).append(" ");
            }

            res.add(sb.toString().trim());
            sentence.remove(sentence.size() - 1);
        }
    }
}
