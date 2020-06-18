package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountPrimesTest {
    private CountPrimes countPrimes;

    @Before
    public void setUp() {
        countPrimes = new CountPrimes();
    }

    @Test
    public void test_1() {
        int count = countPrimes.countPrimes(10);

        assertThat(count).isEqualTo(4);
    }
}