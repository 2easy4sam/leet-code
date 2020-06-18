package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertSortedArrayToBSTTest {
    private ConvertSortedArrayToBST convertSortedArrayToBST;

    @Before
    public void setUp() {
        convertSortedArrayToBST = new ConvertSortedArrayToBST();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{1, 2, 3, 4, 5};

        TreeNode root = convertSortedArrayToBST.sortedArrayToBST(nums);

        assertThat(root.val).isEqualTo(3);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(1);
        assertThat(root.right.val).isEqualTo(5);
        assertThat(root.right.left.val).isEqualTo(4);
    }
}