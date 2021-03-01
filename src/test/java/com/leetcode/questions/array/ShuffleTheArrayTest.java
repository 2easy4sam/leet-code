package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShuffleTheArrayTest {
    private ShuffleTheArray shuffleTheArray;

    @Before
    public void setup() {
        shuffleTheArray = new ShuffleTheArray();
    }

    @Test
    public void test_1() {
        int[] nums = {2, 5, 1, 3, 4, 7};

        assertThat(shuffleTheArray.shuffle(nums, 3)).containsExactly(2, 3, 5, 4, 1, 7);
    }

    @Test
    public void test_2() {
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};

        assertThat(shuffleTheArray.shuffle(nums, 4)).containsExactly(1, 4, 2, 3, 3, 2, 4, 1);
    }
}