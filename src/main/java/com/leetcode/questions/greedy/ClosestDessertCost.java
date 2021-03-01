package com.leetcode.questions.greedy;

public class ClosestDessertCost {
    private int closest = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int i = 0; i < baseCosts.length && closest != target; i++) {
            dfs(baseCosts[i], target, 0, toppingCosts);
        }

        return closest;
    }

    private void dfs(int cost, int target, int i, int[] toppingCosts) {
        if (cost == target) {
            closest = target;
            minDiff = 0;
            return;
        }

        int diff = Math.abs(cost - target);

        if (diff < minDiff) {
            minDiff = diff;
            closest = cost;
        } else if (diff == minDiff) {
            if (cost < closest) closest = cost;
        }

        if (i < toppingCosts.length) {
            dfs(cost, target, i + 1, toppingCosts);
            dfs(cost + toppingCosts[i], target, i + 1, toppingCosts);
            dfs(cost + 2 * toppingCosts[i], target, i + 1, toppingCosts);
        }
    }
}
