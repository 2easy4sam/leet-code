package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumNumberOfBalloonsTest {
    private MaximumNumberOfBalloons maximumNumberOfBalloons;

    @Before
    public void setUp() {
        maximumNumberOfBalloons = new MaximumNumberOfBalloons();
    }

    @Test
    public void test_1() {
        String text = "nlaebolko";

        assertThat(maximumNumberOfBalloons.maxNumberOfBalloons2(text)).isEqualTo(1);
    }

    @Test
    public void test_2() {
        String text = "loonbalxballpoon";

        assertThat(maximumNumberOfBalloons.maxNumberOfBalloons2(text)).isEqualTo(2);
    }

    @Test
    public void test_3() {
        String text = "leetcode";

        assertThat(maximumNumberOfBalloons.maxNumberOfBalloons2(text)).isEqualTo(0);
    }

    @Test
    public void test_4() {
        String text = "nolab";

        assertThat(maximumNumberOfBalloons.maxNumberOfBalloons2(text)).isEqualTo(0);
    }
}