package com.leetcode.questions.greedy;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PutBoxesIntoTheWarehouseIITest {
    private PutBoxesIntoTheWarehouseII putBoxesIntoTheWarehouseII;

    @Before
    public void setUp() {
        putBoxesIntoTheWarehouseII = new PutBoxesIntoTheWarehouseII();
    }

    @Test
    public void test_1() {
        int[] boxes = new int[]{1, 2, 2, 3, 4};
        int[] warehouse = new int[]{3, 4, 1, 2};

        assertThat(putBoxesIntoTheWarehouseII.maxBoxesInWarehouse(boxes, warehouse)).isEqualTo(4);
    }
}