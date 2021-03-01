package com.leetcode.questions.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedWords {
    private List<String> res;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        res = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String word : words) {
            dfs(countMap, words, word, 0, 0);
        }

        return res;
    }

    private void dfs(Map<String, Integer> countMap, String[] words, String word, int start, int nWords) {
        if (start == word.length() - 1) {
            if (nWords > 1) {
                res.add(word);
                countMap.put(word, nWords);
            }

            return;
        }

        String curr = word.substring(start);

        if (countMap.containsKey(curr) && countMap.get(curr) > 1) {
            countMap.put(word, nWords + countMap.get(curr));
            res.add(word);
            return;
        }

        for (String w : words) {
            if (curr.startsWith(w)) {
                dfs(countMap, words, word, start + w.length(), nWords + 1);
            }
        }
    }
}
