package com.leetcode.questions.dfs;

public class KthSymbolInGrammar {
    public int kthGrammar(int N, int K) {
        return dfs("0", N, 0).charAt(K);
    }

    private String dfs(String s, int n, int curr) {
        if (curr == n) return s;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }

        return dfs(sb.toString(), n, curr + 1);
    }
}
