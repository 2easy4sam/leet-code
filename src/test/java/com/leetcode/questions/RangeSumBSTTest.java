package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangeSumBSTTest {
    private RangeSumBST rangeSumBST;

    @Before
    public void setUp() {
        rangeSumBST = new RangeSumBST();
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);

        int L = 3;
        int R = 20;

        int sum = rangeSumBST.rangeSumBST(root, L, R);
        assertThat(sum).isEqualTo(23);
    }
}