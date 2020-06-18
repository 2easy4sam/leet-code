package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class TwoSumBSTTest {
    private TwoSumBST twoSumBST;

    @Before
    public void setUp() {
        twoSumBST = new TwoSumBST();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        twoSumBST.findTarget(root, 4);
    }
}