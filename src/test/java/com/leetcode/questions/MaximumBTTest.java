package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumBTTest {
    private MaximumBT maximumBT;

    @Before
    public void setUp() {
        maximumBT = new MaximumBT();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};

        TreeNode root = maximumBT.constructMaximumBinaryTree(nums);

        assertThat(root.val).isEqualTo(6);
        assertThat(root.left.val).isEqualTo(3);
        assertThat(root.right.val).isEqualTo(5);
        assertThat(root.right.left.val).isEqualTo(0);
        assertThat(root.left.right.val).isEqualTo(2);
        assertThat(root.left.right.right.val).isEqualTo(1);
    }
}