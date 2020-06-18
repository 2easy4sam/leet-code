package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PermutationsTest {
    private Permutations permutations;

    @Before
    public void setUp() {
        permutations = new Permutations();
    }

    @Test
    public void test_1() {
        List<List<Integer>> res = permutations.permute(new int[]{1, 2, 3});
    }
}