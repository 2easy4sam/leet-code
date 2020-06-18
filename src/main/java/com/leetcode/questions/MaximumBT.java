package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.Arrays;

public class MaximumBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        // find the largest num
        int largest = nums[0], largestIdx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
                largestIdx = i;
            }
        }

        TreeNode root = new TreeNode(largest);
        root.left = constructMaximumBinaryTree(Arrays.copyOf(nums, largestIdx));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, largestIdx + 1, nums.length));

        return root;
    }
}
