package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindLeavesOfBTTest {
    private FindLeavesOfBT findLeavesOfBT;

    @Before
    public void setUp() {
        findLeavesOfBT = new FindLeavesOfBT();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> actual = findLeavesOfBT.findLeaves(root);

        assertThat(actual.get(0)).containsExactly(4, 5, 3);
        assertThat(actual.get(1)).containsExactly(2);
        assertThat(actual.get(2)).containsExactly(1);
    }
}