package com.leetcode.questions;

import java.util.Stack;

public class BasicCalculatorIII {

    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0, i = 0;

        while (i < len) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (isSign(c) || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }

            if (c == '(') {
                i++;
                int cnt = 1, start = i;

                while (i < len && cnt != 0) {
                    if (s.charAt(i) == '(') cnt++;
                    else if (s.charAt(i) == ')') cnt--;
                    i++;
                }
                // get the last digit before the matching closed bracket
                i--;
                String subExpr = s.substring(start, i);
                int res = calculate(subExpr);

                /*
                not empty, it means that before this sub-expression
                there was another subexpression or a number
                */
                if (sign == '+') {
                    stack.push(res);
                } else if (sign == '-') {
                    stack.push(-res);
                } else if (sign == '*') {
                    stack.push(stack.pop() * res);
                } else if (sign == '/') {
                    stack.push(stack.pop() / res);
                }

                sign = ' ';
                num = 0;
            }

            i++;
        }

        int res = 0;

        while (!stack.isEmpty()) res += stack.pop();

        return res;
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
