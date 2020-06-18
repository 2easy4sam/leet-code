package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueMorseRepresentationsTest {
    private UniqueMorseRepresentations uniqueMorseRepresentations;

    @Before
    public void setUp() {
        uniqueMorseRepresentations = new UniqueMorseRepresentations();
    }

    @Test
    public void test() {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};

        int count = uniqueMorseRepresentations.solve(words);
        assertThat(count).isEqualTo(2);
    }
}