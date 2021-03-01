package com.leetcode.questions.dfs;

import java.util.ArrayList;
import java.util.List;

public class MiniParser {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public static class NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            list = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            val = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return val != null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return val;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            val = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return list;
        }
    }

    /*
    - intuition:
        - whenever a [] is found, when know that it's a NI containing a list of NIs
    */
    public NestedInteger deserialize(String s) {
        return dfs(s, new NestedInteger(), 0);
    }

    private NestedInteger dfs(String s, NestedInteger p, int depth) {
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                // find the matching ]
                int cnt = 1, tmp = i;

                while (cnt != 0 && ++tmp < s.length()) {
                    if (s.charAt(tmp) == '[') {
                        cnt++;
                    } else if (s.charAt(tmp) == ']') {
                        cnt--;
                    }
                }

                // tmp is now pointing at a ]
                // the next character is either , or end-of-line
                NestedInteger ni = new NestedInteger();
                p.add(dfs(s.substring(i + 1, tmp), ni, depth + 1));
                i = ++tmp;
            } else if (isDigit(s.charAt(i))) {
                // neither [ nor ,
                int tmp = i;

                while (isDigit(s.charAt(tmp))) {
                    tmp++;
                }

                int num = Integer.parseInt(s.substring(i, tmp));

                if (depth > 0) {
                    p.add(new NestedInteger(num));
                } else {
                    p.setInteger(num);
                }

                i = ++tmp;
            } else {
                i++;
            }
        }

        return p;
    }

    private boolean isDigit(char c) {
        int num = c - '0';
        return c == '-' || (num >= 0 && num <= 9);
    }
}
