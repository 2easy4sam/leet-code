package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfGoodLeafNodesPairs1530 {
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> trails = new HashMap<>();
        dfs(trails, new ArrayList<>(), root);
        List<TreeNode> leaves = new ArrayList<>(trails.keySet());

        int cnt = 0;

        for (int i = 0; i < leaves.size(); i++) {
            for (int j = i + 1; j < leaves.size(); j++) {
                List<TreeNode> trail_a = trails.get(leaves.get(i));
                List<TreeNode> trail_b = trails.get(leaves.get(j));

                for (int k = 0; k < Math.min(trail_a.size(), trail_b.size()); k++) {
                    if (trail_a.get(k) != trail_b.get(k)) {
                        int d = trail_a.size() - k + trail_b.size() - k;
                        if (d <= distance) cnt++;
                        break;
                    }
                }
            }
        }

        return cnt;
    }

    private void dfs(Map<TreeNode, List<TreeNode>> trails, List<TreeNode> trail, TreeNode curr) {
        if (curr == null) return;
        List<TreeNode> tmp = new ArrayList<>(trail);
        tmp.add(curr);

        if (curr.left == null && curr.right == null) {
            // leaf node
            trails.put(curr, tmp);
            return;
        }

        dfs(trails, tmp, curr.left);
        dfs(trails, tmp, curr.right);
    }
}
