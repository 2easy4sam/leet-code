package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LevelOrderBSTTest {
    private LevelOrderBST levelOrderBST;

    @Before
    public void setUp() {
        levelOrderBST = new LevelOrderBST();
    }

    @Test
    public void test() {
        LevelOrderBST.TreeNode F = new LevelOrderBST.TreeNode(6);

        F.left = new LevelOrderBST.TreeNode(2);
        F.right = new LevelOrderBST.TreeNode(7);

        F.left.left = new LevelOrderBST.TreeNode(1);
        F.left.right = new LevelOrderBST.TreeNode(4);

        F.left.right.left = new LevelOrderBST.TreeNode(3);
        F.left.right.right = new LevelOrderBST.TreeNode(5);

        F.right.right = new LevelOrderBST.TreeNode(9);

        F.right.right.left = new LevelOrderBST.TreeNode(8);

        List<List<Integer>> results = levelOrderBST.solve(F);
    }
}