package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.Arrays;

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a
 * binary tree in which the depth of the two subtrees of every node
 * never differ by more than 1.
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(
                Arrays.copyOfRange(nums, 0, mid));
        node.right = sortedArrayToBST(
                Arrays.copyOfRange(nums, mid + 1, nums.length));

        return node;
    }
}
