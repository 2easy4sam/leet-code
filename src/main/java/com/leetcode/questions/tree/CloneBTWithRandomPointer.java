package com.leetcode.questions.tree;

import java.util.HashMap;
import java.util.Map;

public class CloneBTWithRandomPointer {
    public static class RandomNode {
        int val;
        RandomNode left, right, random;

        RandomNode(int val) {
            this.val = val;
        }
    }

    private int idx;
    private Map<Integer, RandomNode> copyMap;
    private Map<RandomNode, Integer> nodeIndexMap;
    private Map<Integer, RandomNode> indexNodeMap;

    public RandomNode copyRandomBinaryTree(RandomNode root) {
        if (root == null) return null;
        idx = 0;

        copyMap = new HashMap<>();

        nodeIndexMap = new HashMap<>();
        indexNodeMap = new HashMap<>();

        // traverse the tree and create a new tree without random pointers
        dfs(root);
        idx = 0;

        // traverse the tree again to populate random pointers
        bond();

        return copyMap.get(0);
    }

    private void dfs(RandomNode original) {
        if (original == null) return;
        nodeIndexMap.put(original, idx);
        indexNodeMap.put(idx, original);
        copyMap.put(idx, new RandomNode(original.val));
        idx++;

        dfs(original.left);
        dfs(original.right);
    }

    private void bond() {
        if (!indexNodeMap.containsKey(idx)) return;
        RandomNode original = indexNodeMap.get(idx);
        RandomNode copy = copyMap.get(idx);

        if (original.random != null) {
            int randomIdx = nodeIndexMap.get(original.random);
            copy.random = copyMap.get(randomIdx);
        }

        if (original.left != null) {
            int leftIdx = nodeIndexMap.get(original.left);
            copy.left = copyMap.get(leftIdx);
            idx++;
            bond();
        }

        if (original.right != null) {
            int rightIdx = nodeIndexMap.get(original.right);
            copy.right = copyMap.get(rightIdx);
            idx++;
            bond();
        }
    }
}
