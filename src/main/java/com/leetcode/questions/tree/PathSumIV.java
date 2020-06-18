package com.leetcode.questions.tree;

/**
 * If the depth of a tree is smaller than 5, then this tree can be
 * represented by a list of three-digits integers.
 *
 * For each integer in this list:
 *
 * The hundreds digit represents the depth D of this node,
 * 1 <= D <= 4.
 * The tens digit represents the position P of this node in the level
 * it belongs to, 1 <= P <= 8. The position is the same as that in a
 * full binary tree.
 * The units digit represents the value V of this node, 0 <= V <= 9.
 *
 *
 * Given a list of ascending three-digits integers representing a
 * binary tree with the depth smaller than 5, you need to return the
 * sum of all paths from the root towards the leaves.
 */
public class PathSumIV {

    public int pathSum(int[] nums) {
        // hundreds -> depth, max = 4
        // tens     -> position in level, max = 2 ^ (depth - 1)
        // units    -> value of the node
        // number of nodes = nums.length
        int maxNodes = 15; // 1 + 2 + 4 + 8
        Integer[] roots = new Integer[maxNodes];

        for (int num : nums) {
            int units = num % 10;
            int tens = (num / 10) % 10;
            int hundreds = num / 100;

            int depth = hundreds - 1;   // 0-indexed
            int levelMaxNodes = (int) Math.pow(2, depth);
            int idx = levelMaxNodes - 2 + tens;
            roots[idx] = units;
        }

        return dfs(roots, 0, 0);
    }

    private int dfs(Integer[] roots, int sum, int index) {
        int sumSoFar = sum + roots[index];
        int total = 0;

        int leftIdx = index * 2 + 1, rightIdx = index * 2 + 2;
        boolean hasLeft = leftIdx < roots.length && roots[leftIdx] != null;
        boolean hasRight = rightIdx < roots.length && roots[rightIdx] != null;

        if (hasLeft) {
            // left
            int left = dfs(roots, sumSoFar, leftIdx);
            total += left;
        }
        if (hasRight) {
            // right
            int right = dfs(roots, sumSoFar, rightIdx);
            total += right;
        }

        if (!hasLeft && !hasRight) {
            total += sumSoFar;
        }

        return total;
    }
}
