package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GasStationTest {
    private GasStation gasStation;

    @Before
    public void setUp() {
        gasStation = new GasStation();
    }

    @Test
    public void test_1() {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};

        assertThat(gasStation.canCompleteCircuit(gas, cost)).isEqualTo(3);
    }

    @Test
    public void test_2() {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};

        assertThat(gasStation.canCompleteCircuit(gas, cost)).isEqualTo(-1);
    }
}