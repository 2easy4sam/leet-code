package com.leetcode.questions;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                Character prev = stack.poll();
                if (prev == null ||
                        c == ')' && prev != '(' ||
                        c == ']' && prev != '[' ||
                        c == '}' && prev != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
