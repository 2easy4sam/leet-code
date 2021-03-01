package com.leetcode.questions.string;

public class MinimumWindowString {
    public String minWindow(String s, String t) {
        // a map that keeps track of the count of each char in t
        int[] cntMap = new int[128];

        for (char c : t.toCharArray()) cntMap[c]++;

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, cnt = t.length();


        while (end < s.length()) {
            char c1 = s.charAt(end);
            // only chars in t will have a count > 0
            // e.g. s = "abc", t = "a"
            // cntMap = {1,0,0}
            if (cntMap[c1] > 0) cnt--;
            // move end so that we know chars in t will be between start and end
            end++;
            cntMap[c1]--;

            // when cnt becomes 0, we know that end is at a position where
            // all occurrences of the chars in t are before it
            while (cnt == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }

                char c2 = s.charAt(start);
                cntMap[c2]++;
                // only chars in t will have a count > 0
                // as chars that are in s but NOT t will have
                // negative counts
                if (cntMap[c2] > 0) cnt++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
}
