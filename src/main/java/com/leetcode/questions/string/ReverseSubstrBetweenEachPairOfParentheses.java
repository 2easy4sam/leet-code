package com.leetcode.questions.string;

public class ReverseSubstrBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int begin = i;
                int cnt = 1;

                while (cnt != 0 && ++i < s.length()) {
                    if (s.charAt(i) == '(') cnt++;
                    else if (s.charAt(i) == ')') cnt--;
                }

                String head = s.substring(0, begin);
                String tail = s.substring(i + 1);

                s = head + reverse(s.substring(begin + 1, i)) + tail;
                i = 0;
                continue;
            }

            i++;
        }

        return s;
    }

    private String reverse(String s) {
        int i = 0, j = s.length() - 1;
        char[] charArr = s.toCharArray();

        while (i < j) {
            char tmp = charArr[j];
            charArr[j] = charArr[i] == '('
                    ? ')'
                    : charArr[i] == ')'
                    ? '('
                    : charArr[i];
            charArr[i] = tmp == '('
                    ? ')'
                    : tmp == ')'
                    ? '('
                    : tmp;
            i++;
            j--;
        }

        return new String(charArr);
    }
}
