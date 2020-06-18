package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CapacityToShipPackagesInDDaysTest {
    private CapacityToShipPackagesInDDays capacityToShipPackagesInDDays;

    @Before
    public void setUp() {
        capacityToShipPackagesInDDays = new CapacityToShipPackagesInDDays();
    }

    @Test
    public void test_1() {
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;

        assertThat(capacityToShipPackagesInDDays.shipWithinDays(weights, D)).isEqualTo(15);
    }
}