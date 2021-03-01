package com.leetcode.questions;

public class BasicCalculatorII {

    public int calculate(String s) {
        /*
        - do it in two passes
            - in the first pass, we process all the multiplications and divisions
            - in the second pass, we take care of the remaining operations, i.e. additions and subtractions
        */

        // 1st pass
        int i = 0, curr = -1, numStartIdx = 0;
        char op = '+';

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0, factor = 10;
                int tmp = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * factor + (s.charAt(i) - '0');
                    i++;
                }
                i--;

                if (op == '*') {
                    num = curr * num;
                    String first = s.substring(0, numStartIdx);
                    String second = s.substring(i + 1);
                    s = first + num + second;
                    i = numStartIdx - 1;
                    op = '+';
                } else if (op == '/') {
                    num = curr / num;
                    String first = s.substring(0, numStartIdx);
                    String second = s.substring(i + 1);
                    s = first + num + second;
                    i = numStartIdx - 1;
                    op = '+';
                }

                numStartIdx = tmp;
                curr = num;
            } else if (s.charAt(i) == '*') {
                op = '*';
            } else if (s.charAt(i) == '/') {
                op = '/';
            } else if (s.charAt(i) == '+') {
                op = '+';
            } else if (s.charAt(i) == '-') {
                op = '-';
            }

            i++;
        }

        i = 0;
        op = '+';
        int res = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '+') {
                op = '+';
            } else if (c == '-') {
                op = '-';
            } else if (Character.isDigit(c)) {
                int num = 0, factor = 10;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * factor + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                if (op == '+') {
                    res += num;
                } else {
                    res -= num;
                }
            }
            i++;
        }

        return res;
    }
}
