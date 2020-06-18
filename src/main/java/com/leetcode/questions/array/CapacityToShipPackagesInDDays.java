package com.leetcode.questions.array;

public class CapacityToShipPackagesInDDays {

    /*
    find all possible ways to partition weights into
    D parts, the part that has the highest value is the min capacity for this
    particular partitioning

    batch size >= 1 AND batch size

    the capacity should be at least the weight of the heaviest
    */

    private int min = Integer.MAX_VALUE;

    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        if (D == 1) return right;

        while (left < right) {
            int mid = (left + right) / 2, days = 1, curr = 0;

            for (int w : weights) {
                if (curr + w > mid) {
                    // weight has exceeded the capacity
                    // increment days needed to ship all packages
                    days++;
                    curr = 0;
                }

                curr += w;
            }

            // if the total number of days needed is more than
            // the specified days, we need to increase the capacity
            if (days > D) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    /*
    backtracking approach
    */
    public int shipWithinDaysBT(int[] weights, int D) {
        if (D == 1) {
            int capacity = 0;
            for (int weight : weights) capacity += weight;
            return capacity;
        }

        for (int size = 1; size <= weights.length - D + 1; size++) {
            dfs(weights, 0, size, 0, D - 1);
        }

        return min;
    }

    private void dfs(int[] weights, int i, int size, int capacity, int D) {
        int batchCapacity = 0;

        for (int j = 0; j < size && i < weights.length; j++) {
            batchCapacity += weights[i++];
        }

        capacity = Math.max(capacity, batchCapacity);

        if (D == 0) {
            min = Math.min(min, capacity);
            return;
        }

        if (D == 1) {
            dfs(weights, i, weights.length - i, capacity, D - 1);
        } else {
            for (int newSize = 1; newSize <= weights.length - i + 1; newSize++) {
                dfs(weights, i, newSize, capacity, D - 1);
            }
        }
    }
}
