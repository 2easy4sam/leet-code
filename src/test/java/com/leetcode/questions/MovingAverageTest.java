package com.leetcode.questions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingAverageTest {
    private MovingAverage movingAverage;

    @Test
    public void test_1() {
        int size = 3;
        int[] inputs = new int[]{1, 10, 3, 5};
        double[] outputs = new double[inputs.length];

        movingAverage = new MovingAverage(size);

        for (int i = 0; i < inputs.length; i++) {
            outputs[i] = movingAverage.next(inputs[i]);
        }

        assertThat(outputs).containsSequence(1.0, 5.5, 4.66667, 6.0);
    }
}