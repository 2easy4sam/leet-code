package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DIStringMatchTest {
    private DIStringMatch diStringMatch;

    @Before
    public void setUp() {
        diStringMatch = new DIStringMatch();
    }

    @Test
    public void test_allIncreasing() {
        String s = "III";

        int[] res = diStringMatch.diStringMatch(s);

        assertThat(res.length).isEqualTo(4);
        assertThat(res).containsSequence(0, 1, 2, 3);
    }

    @Test
    public void test_allDecreasing() {
        String s = "DDD";

        int[] res = diStringMatch.diStringMatch(s);

        assertThat(res.length).isEqualTo(4);
        assertThat(res).containsSequence(3, 2, 1, 0);
    }

    @Test
    public void test_mixed() {
        String s = "IDID";

        int[] res = diStringMatch.diStringMatch(s);
        System.out.println(Arrays.toString(res));
    }
}