package com.leetcode.questions;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0)
            return Collections.emptyList();

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        bucketSort(entries);

        return entries
                .subList(0, k)
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private void bucketSort(List<Map.Entry<String, Integer>> entries) {
        int nBuckets = entries.size();
        // 1. initialize buckets
        // 2. find the largest element
        // 3. distribute elements to buckets
        // 4. sort each bucket
        // 5. combine sorted buckets

        List<List<Map.Entry<String, Integer>>> buckets = new ArrayList<>();

        for (int i = 0; i < nBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        int max = findMax(entries);

        for (Map.Entry<String, Integer> entry : entries) {
            int idx = hash(entry.getValue(), max, nBuckets);

            buckets.get(idx).add(entry);
        }

        for (List<Map.Entry<String, Integer>> bucket : buckets) {
            // sort by count
            // then alphabetical order
            bucket.sort((e1, e2) -> {
                if (e1.getValue() > e2.getValue()) return 1;
                if (e1.getValue() == e2.getValue()) {
                    TrieNode t1 = createTrie(e1.getKey());
                    TrieNode t2 = createTrie(e2.getKey());

                    if (isAlphabeticallyLower(t1, t2)) {
                        return -1;
                    }

                    return 1;
                }

                return -1;
            });
        }

        int k = 0;
        for (int i = nBuckets - 1; i >= 0; i--) {
            List<Map.Entry<String, Integer>> bucket = buckets.get(i);

            for (int j = bucket.size() - 1; j >= 0; j--) {
                entries.set(k++, bucket.get(j));
            }
        }
    }

    private int findMax(List<Map.Entry<String, Integer>> entries) {
        int max = entries.get(0).getValue();

        for (Map.Entry<String, Integer> entry : entries) {
            max = Math.max(max, entry.getValue());
        }

        return max;
    }

    private int hash(int cnt, int max, int nBuckets) {
        return (int) (double) cnt / max * (nBuckets - 1);
    }

    private boolean isAlphabeticallyLower(TrieNode t1, TrieNode t2) {
        int i = 0, j = 0;

        TrieNode child1 = null;
        TrieNode child2 = null;

        while (i < 26) {
            if ((child1 = t1.children[i]) != null) break;
            i++;
        }

        while (j < 26) {
            if ((child2 = t2.children[j]) != null) break;
            j++;
        }

        // if child1 is null and child2 is not, return true
        // if child1 is not null and child2 is, return false
        // if neither is null, compare i to j:
        // true when i < j
        // false when i > j
        // else, repeat the above steps

        if (child1 == null) return true;
        else if (child2 == null) return false;

        if (i < j) {
            return true;
        } else if (i > j) {
            return false;
        }

        return isAlphabeticallyLower(child1, child2);
    }

    private TrieNode createTrie(String s) {
        TrieNode t = new TrieNode();
        TrieNode cur = t;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }

            cur = cur.children[idx];
        }

        cur.isWord = true;
        return t;
    }

    public static class TrieNode {
        public TrieNode[] children;
        public boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
