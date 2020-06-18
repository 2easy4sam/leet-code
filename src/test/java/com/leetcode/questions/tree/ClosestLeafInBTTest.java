package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.SerializeAndDeserializeBT;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClosestLeafInBTTest {
    private ClosestLeafInBT closestLeafInBT;
    private SerializeAndDeserializeBT serializeAndDeserializeBT;

    @Before
    public void setUp() {
        closestLeafInBT = new ClosestLeafInBT();
        serializeAndDeserializeBT = new SerializeAndDeserializeBT();
    }

    @Test
    public void test_whenTargetIsRoot() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        assertThat(closestLeafInBT.findClosestLeaf(root, 1)).isEqualTo(2);
    }

    @Test
    public void test_whenTargetIsLeaf() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        assertThat(closestLeafInBT.findClosestLeaf(root, 2)).isEqualTo(2);
    }

    @Test
    public void test_whenTargetIsLeftMostLeaf() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        assertThat(closestLeafInBT.findClosestLeaf(root, 4)).isEqualTo(4);
    }

    @Test
    public void test_case334() {
        TreeNode root = serializeAndDeserializeBT.deserialize("[1,2,3,4,null,null,7,8,9,null,null,12,null,null,null,null,13,null,14]");

        assertThat(closestLeafInBT.findClosestLeaf(root, 8)).isEqualTo(9);
    }

    @Test
    public void test_case334_2() {
        TreeNode root = serializeAndDeserializeBT.deserialize("[1,2,3,4,null,null,7,8,9,null,null,12,null,null,null,null,13,null,14]");

        assertThat(closestLeafInBT.findClosestLeaf(root, 12)).isEqualTo(14);
    }
}