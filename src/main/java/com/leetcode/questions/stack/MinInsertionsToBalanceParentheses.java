package com.leetcode.questions.stack;

import java.util.Stack;

public class MinInsertionsToBalanceParentheses {
    public int minInsertions(String s) {
        int i = 0, cnt = 0;
        Stack<Character> stack = new Stack<>();

        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == '(') {
                stack.push('(');
                i++;
            }

            // now i is pointing at a )
            if (!stack.isEmpty() && stack.peek() == '(' && i + 1 < s.length() && s.charAt(i + 1) == ')') {
                stack.pop();
                i += 2;
                continue;
            }

            stack.push(')');
            i++;
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == ')') {
                int l = 0, r = 0;

                for (int j = 0; j < 2 && !stack.isEmpty(); j++) {
                    if (stack.pop() == ')') {
                        r++;
                    } else {
                        l++;
                    }
                }

                if (l == 1 && r == 1) {
                    cnt++;
                } else if (r == 2) {
                    cnt++;
                } else if (l == 0 && r == 1) {
                    cnt += 2;
                }
            } else {
                stack.pop();
                cnt += 2;
            }
        }

        return cnt;
    }
}
