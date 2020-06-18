package com.leetcode.questions.backtracking;

import java.util.*;

public class KthHappyString {

    private static final char[] ABC = new char[]{'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        /*
        definition: a happy string is a string where a char
        doesn't occur twice consecutively, e.g. aab
        however, aba is considered happy even though a occurs
        twice
        */
        Set<String> set = new HashSet<>();
        List<String> abc = Arrays.asList("a", "b", "c");
        if (n == 1) set.addAll(abc);
        Queue<String> q = new LinkedList<>(abc);

        int len = 1;
        while (!q.isEmpty() && len < n) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String s = q.poll();

                for (char c : ABC) {
                    StringBuilder sb = new StringBuilder();

                    if (s.charAt(s.length() - 1) == c) continue;
                    sb.append(s).append(c);
                    if (sb.length() == n) {
                        set.add(sb.toString());
                    } else {
                        q.offer(sb.toString());
                    }
                }
            }

            len++;
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return k > list.size() ? "" : list.get(k - 1);
    }
}
