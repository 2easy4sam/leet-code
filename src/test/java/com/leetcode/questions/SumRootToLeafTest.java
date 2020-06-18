package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class SumRootToLeafTest {
    private SumRootToLeaf sumRootToLeaf;

    @Before
    public void setUp() {
        sumRootToLeaf = new SumRootToLeaf();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);

        sumRootToLeaf.sumRootToLeaf(root);
    }
}