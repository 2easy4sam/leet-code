package com.leetcode.questions;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int totalTank = 0;
        int curGas = 0;
        int startIdx = 0;

        for (int i = 0; i < len; i++) {
            totalTank += gas[i] - cost[i];
            curGas += gas[i] - cost[i];

            if (curGas < 0) {
                startIdx = i + 1;
                curGas = 0;
            }
        }

        return totalTank < 0 ? -1 : startIdx;
    }
}
