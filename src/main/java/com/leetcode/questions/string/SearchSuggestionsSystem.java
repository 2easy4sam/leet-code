package com.leetcode.questions.string;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {
    private Trie root;

    /*
    Trie + DFS
    - when typing a character, check if that particular character at the current level is present
    */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Trie();
        // 1. iterate over products and build trie
        // 2. search in built tree the word char by char
        // 2.1. stop when list reaches the size of searchWord.length() (n)
        buildTrie(products);
        List<List<String>> results = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < searchWord.length(); i++) {
            sb.append(searchWord.charAt(i));
            results.add(suggest(sb.toString()));
        }

        return results;
    }

    private List<String> suggest(String str) {
        // at most 3 words
        List<String> names = new ArrayList<>();
        Trie curr = root;
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < str.length() && curr != null; i++) {
            char c = str.charAt(i);
            int idx = c - 'a';

            curr = curr.nodes[idx];
        }

        autoComplete(curr, sb, names);

        return names;
    }

    private void autoComplete(Trie trie, StringBuilder sb, List<String> names) {
        if (trie == null || names.size() == 3) return;
        if (trie.isWord) names.add(sb.toString());

        for (int i = 0; i < 26; i++) {
            if (trie.nodes[i] != null) {
                autoComplete(trie.nodes[i], new StringBuilder(sb).append((char) (i + 97)), names);
            }
        }
    }

    private void buildTrie(String[] products) {
        for (String product : products) {
            Trie curr = root;

            for (int i = 0; i < product.length(); i++) {
                char c = product.charAt(i);
                int idx = c - 'a';

                if (curr.nodes[idx] == null) {
                    curr.nodes[idx] = new Trie();
                }

                curr = curr.nodes[idx];
            }

            curr.isWord = true;
        }
    }

    private static class Trie {
        Trie[] nodes;
        boolean isWord;

        public Trie() {
            nodes = new Trie[26];
            isWord = false;
        }
    }
}
