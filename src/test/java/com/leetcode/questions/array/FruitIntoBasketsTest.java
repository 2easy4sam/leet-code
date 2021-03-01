package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitIntoBasketsTest {
    private FruitIntoBaskets fruitIntoBaskets;

    @Before
    public void setUp() {
        fruitIntoBaskets = new FruitIntoBaskets();
    }

    @Test
    public void test_1() {
        int[] tree = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        assertThat(fruitIntoBaskets.totalFruit(tree)).isEqualTo(5);
    }
}