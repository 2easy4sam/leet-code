package com.leetcode.questions.string;

public class DecodeString {
    public String decodeString(String s) {
        if (s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();

        int i = 0, digitBegin = -1, l = -1, tracker = 0;

        // find the 1st open bracket and its matching close bracket
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '[') {
                if (l == -1) l = i; // 1st open bracket
                tracker++;
            } else if (c == ']') {
                tracker--;
            } else if (isDigit(c) && digitBegin == -1) {
                digitBegin = i;
            }

            if (l != -1 && tracker == 0) break;
            i++;
        }

        if (l == -1) {
            // we haven't found any brackets, therefore no digits as well
            // therefore we know that in the current state of the recursion
            return s;
        }

        String sub = decodeString(s.substring(l + 1, i));

        // all chars between digitBegin and l (exclusive) are digits
        int multiplier = Integer.parseInt(s.substring(digitBegin, l));

        if (digitBegin > 0) sb.append(s, 0, digitBegin);
        while (multiplier-- != 0) sb.append(sub);
        sb.append(decodeString(s.substring(i + 1)));

        return sb.toString();
    }

    private boolean isDigit(char c) {
        int diff = c - '0';
        return diff >= 0 && diff <= 9;
    }
}
