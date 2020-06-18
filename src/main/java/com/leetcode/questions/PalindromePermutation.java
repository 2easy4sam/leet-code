package com.leetcode.questions;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }

        return set.isEmpty() || set.size() == 1;
    }
}
