package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PathInZigZagLabelledBinaryTreeTest {
    private PathInZigZagLabelledBinaryTree pathInZigZagLabelledBinaryTree;

    @Before
    public void setUp() {
        pathInZigZagLabelledBinaryTree = new PathInZigZagLabelledBinaryTree();
    }

    @Test
    public void test_1() {
        List<Integer> actual = pathInZigZagLabelledBinaryTree.pathInZigZagTree(14);

        assertThat(actual).containsExactly(1, 3, 4, 14);
    }
}