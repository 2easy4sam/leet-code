package com.leetcode.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2) return false;

        if (A.equals(B)) {
            Set<Character> charSet = new HashSet<>();
            for (char c : A.toCharArray()) charSet.add(c);
            return charSet.size() < A.length();
        }

        List<Integer> indices = new ArrayList<>();

        for (int i = 0, j = A.length() - 1; i < j; i++, j--) {
            if (A.charAt(i) != B.charAt(i)) indices.add(i);
            if (A.charAt(j) != B.charAt(j)) indices.add(j);
        }

        return indices.size() == 2 && A.charAt(indices.get(0)) ==
                B.charAt(indices.get(1)) && A.charAt(indices.get(1)) == B.charAt(indices.get(0));
    }
}
