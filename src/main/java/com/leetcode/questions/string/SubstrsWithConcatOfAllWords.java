package com.leetcode.questions.string;

import java.util.*;

public class SubstrsWithConcatOfAllWords {
    private Set<String> concats;

    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        concats = new HashSet<>();
        int wordLen = words[0].length();
        char[] concat = new char[words.length * wordLen];
        boolean[] used = new boolean[words.length];

        for (int wid = 0; wid < words.length; wid++) {
            used[wid] = true;
            dfs(words, used, concat, wid, 0);
            used[wid] = false;
        }

        for (String c : concats) {
            int idx = s.indexOf(c);

            while (idx != -1) {
                res.add(idx);
                idx = s.indexOf(c, idx + c.length());
            }
        }

        return res;
    }

    private void dfs(String[] words, boolean[] used, char[] concat, int wid, int idx) {
        String word = words[wid];

        int i = 0;

        while (i < word.length()) {
            concat[idx++] = word.charAt(i++);
        }

        if (idx == word.length() * words.length) {
            // end reached, add word to set
            concats.add(new String(concat));
            return;
        }

        for (int nextWid = 0; nextWid < words.length; nextWid++) {
            if (used[nextWid]) continue;
            used[nextWid] = true;

            dfs(words, used, concat, nextWid, idx);

            used[nextWid] = false;
        }
    }
}
