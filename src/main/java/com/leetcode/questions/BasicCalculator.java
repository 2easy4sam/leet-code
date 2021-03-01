package com.leetcode.questions;

public class BasicCalculator {
    public int calculate(String s) {
        char op = '+';
        int prev = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isDigit(c)) {
                if (op == '+') {
                    prev += (c - '0');
                } else {
                    prev -= (c - '0');
                }
            } else if (c == '+') {
                op = '+';
            } else if (c == '-') {
                op = '-';
            } else if (c == '(') {
                // find the matching closed bracket
                int cnt = 1;
                int idx = i + 1;

                while (idx < s.length() && cnt != 0) {
                    if (s.charAt(idx) == '(') {
                        cnt++;
                    } else if (s.charAt(idx) == ')') {
                        cnt--;
                    }
                    idx++;
                }

                int res = calculate(s.substring(i + 1, idx - 1));
                if (op == '+') {
                    prev += res;
                } else {
                    prev -= res;
                }

                i = idx - 1;
            }
        }

        return prev;
    }

    private boolean isDigit(char c) {
        int diff = c - '0';
        return diff >= 0 && diff <= 9;
    }
}