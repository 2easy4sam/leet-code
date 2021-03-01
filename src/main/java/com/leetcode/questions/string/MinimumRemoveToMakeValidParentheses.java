package com.leetcode.questions.string;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    sb.deleteCharAt(i);
                    i--;
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }
}
