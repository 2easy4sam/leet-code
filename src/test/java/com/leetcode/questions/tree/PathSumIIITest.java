package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathSumIIITest {
    private PathSumIII pathSumIII;

    @Before
    public void setup() {
        pathSumIII = new PathSumIII();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        assertThat(pathSumIII.pathSum(root, 8)).isEqualTo(3);
    }
}