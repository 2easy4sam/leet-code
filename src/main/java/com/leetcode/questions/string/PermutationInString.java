package com.leetcode.questions.string;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] cnts = new int[26];

        for (char c : s1.toCharArray()) cnts[c - 'a']++;

        int cnt = s1.length(), i = 0;

        for (int j = 0; j < s2.length(); j++) {
            char c = s2.charAt(j);
            if (cnts[c - 'a'] > 0) cnt--;
            cnts[c - 'a']--;

            while (cnt == 0) {
                if (++cnts[s2.charAt(i) - 'a'] > 0) {
                    if (++cnt > 0 && j - i + 1 == s1.length()) {
                        return true;
                    }
                }
                i++;
            }
        }

        return false;
    }
}
