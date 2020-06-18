package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DeepestLeaveSums {
    Map<Integer, Integer> map = new HashMap<>();

    public int deepestLeavesSum(TreeNode root) {
        deepestLeaveSum(root, 1);
        return map.get(map.size());
    }

    private void deepestLeaveSum(TreeNode root, int level) {
        if (root != null) {
            map.put(level, map.getOrDefault(level, 0) + root.val);
            deepestLeaveSum(root.left, level + 1);
            deepestLeaveSum(root.right, level + 1);
        }
    }
}
