package com.leetcode.questions.greedy;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PutBoxesIntoTheWarehouseITest {
    private PutBoxesIntoTheWarehouseI putBoxesIntoTheWarehouseI;

    @Before
    public void setUp() {
        putBoxesIntoTheWarehouseI = new PutBoxesIntoTheWarehouseI();
    }

    @Test
    public void test_1() {
        int[] boxes = new int[]{4, 3, 4, 1};
        int[] warehouse = new int[]{5, 3, 3, 4, 1};

        assertThat(putBoxesIntoTheWarehouseI.maxBoxesInWarehouse(boxes, warehouse)).isEqualTo(3);
    }
}