package com.leetcode.datastructures;


public class Trie {
    public static class TrieNode {
        public boolean isWord;
        // each index represents a character
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        public boolean isAlphabeticallyLower(TrieNode compareTo) {
            return isAlphabeticallyLower(this, compareTo);
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
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode createTrieNode(String s) {
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

    public void insert(String word) {
        TrieNode ws = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }

        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }

        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }

        return true;
    }
}
