package com.leetcode.questions.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given the string s, return the size of the longest substring
containing each vowel an even number of times.

That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of
times.
*/
public class FindTheLongestSubstrContainingVowelsInEvenCounts {
    public int findTheLongestSubstring(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] cnt = new int[26];
        int n = s.length();
        char[] charArr = s.toCharArray();
        char[] reverse = new char[n];

        /*
        count the total number of vowels
        O(n)
        */
        for (int i = 0; i < n; i++) {
            char c = charArr[i];
            cnt[c - 'a']++;
            reverse[n - i - 1] = c;
        }

        /*
        make sure all counts are even
        and these are max count that each vowel can have
        i.e. IF the cnt['a' - 'a'] = 3 THEN count of 'a'
        MUST be <= 3 - 1
        O(k), where k is the size of map
        */
        for (char vowel : vowels) {
            if (cnt[vowel - 'a'] % 2 != 0) cnt[vowel - 'a']--;
        }

        return Math.max(helper(vowels, cnt, charArr), helper(vowels, cnt, reverse));
    }

    private int helper(Set<Character> vowels, int[] maxCnt, char[] charArr) {
        int max = 0, i = 0, j = -1, n = charArr.length;
        int[] cnt = new int[26];

        /*
        at any point, if all vowels have an even count, we calculate max
        */
        while (j < n - 1) {
            if (i > j) {
                j = i;
            } else {
                j++;
            }

            char c = charArr[j];

            if (vowels.contains(c)) {
                cnt[c - 'a']++;

                while (i < n - 1 && cnt[c - 'a'] > maxCnt[c - 'a']) {
                    cnt[charArr[++i - 1] - 'a']--;
                }
            }

            if (allEven(vowels, cnt)) {
                max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }

    private boolean allEven(Set<Character> vowels, int[] cnt) {
        boolean allEven = true;

        for (char vowel : vowels) {
            allEven &= (cnt[vowel - 'a'] % 2 == 0);
        }

        return allEven;
    }
}
