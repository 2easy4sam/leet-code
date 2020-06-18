package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestLeafInBT {
    private Map<Integer, List<Integer>> map;
    private int node = -1;

    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) return 0;
        map = new HashMap<>();
        dfs(root, k, new ArrayList<>());
        if (node != -1) return node;
        if (!map.containsKey(k)) return 0;
        findClosest(k);

        return node;
    }

    private void findClosest(int k) {
        int closest = Integer.MAX_VALUE;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getKey() == k) continue;
            int nodeVal = entry.getKey();
            List<Integer> path = entry.getValue();
            List<Integer> kPath = map.get(k);
            int min = Math.min(path.size(), kPath.size());

            int i = 0;
            while (i < min && path.get(i) == kPath.get(i)) i++;
            int dist = path.subList(i, path.size()).size() + kPath.subList(i, kPath.size()).size();
            if (dist < closest) {
                node = nodeVal;
                closest = dist;
            }
        }
    }

    private void dfs(TreeNode root, int k, List<Integer> path) {
        path.add(root.val);
        if (root.val == k) {
            if (root.left == null && root.right == null) {
                node = root.val;
                return;
            }
            map.put(root.val, path);
        }

        if (root.left == null && root.right == null) {
            // leaf node
            map.put(root.val, path);
        }

        if (root.left != null) dfs(root.left, k, new ArrayList<>(path));
        if (root.right != null) dfs(root.right, k, new ArrayList<>(path));
    }
}
