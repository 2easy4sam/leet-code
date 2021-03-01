package com.leetcode.questions.string;

/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence
of all these characters a, b and c.
TODO: this implementation is wrong
*/
public class NumOfStrsContainingAllThreeChars {
    public int numberOfSubstrings(String s) {
        int[] cnts = new int[3];
        int i = 0, n = s.length(), cnt = 0, nDups = 0;

        /*
        sliding window, O(n)
        */
        while (i < n) {
            char c = s.charAt(i);
            cnts[c - 'a']++;

            if (i >= 2) {
                if (i > 2) cnts[s.charAt(i - 3) - 'a']--;
                if (hasTriplet(cnts)) {
                    cnt += ((i - 2 + 1) + (n - 1 - i) - nDups++);
                }
            }

            i++;
        }

        return cnt;
    }

    private boolean hasTriplet(int[] cnts) {
        boolean flag = true;

        for (int cnt : cnts) flag &= (cnt > 0);

        return flag;
    }
}
