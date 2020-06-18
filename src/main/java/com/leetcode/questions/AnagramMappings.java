package com.leetcode.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Array, Easy
 * Given two lists A and B, and B is an anagram of A. B is
 * an anagram of A means B is made by randomizing the order
 * of the elements in A.
 *
 * We want to find an index mapping P, from A to B. A mapping
 * P[i] = j means the ith element in A appears in B at index j.
 *
 * These lists A and B may contain duplicates. If there are
 * multiple answers, output any of them.
 */
public class AnagramMappings {
    public int[] solve(int[] A, int[] B) {
        if (A == null || A.length == 0) return new int[]{};
        List<Integer> listB = Arrays.stream(B).boxed().collect(Collectors.toList());
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            ans[i] = listB.indexOf(A[i]);
        }

        return ans;
    }
}
