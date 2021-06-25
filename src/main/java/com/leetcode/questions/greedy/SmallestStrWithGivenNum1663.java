package com.leetcode.questions.greedy;

public class SmallestStrWithGivenNum1663 {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, k);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, int n, int k) {
        if (n == sb.length() + 1) {
            sb.append((char) ('a' + k - 1));
            return;
        }

        int len = n - sb.length();
        int d = len * 26 - k;
        int i = d >= 26 ? 1 : 26 - d;
        sb.append((char) ('a' + i - 1));
        dfs(sb, n, k - i);
    }
}
