package com.leetcode.questions;

public class BestTimeToBuyAndSellStock {

    public int maxProfit2(int[] prices) {
        int lowest = Integer.MAX_VALUE, highest = Integer.MIN_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
                highest = prices[i];
                profit = Math.max(highest - lowest, profit);
            }
            if (prices[i] > highest) {
                highest = prices[i];
                profit = Math.max(highest - lowest, profit);
            }
        }

        return profit;
    }

    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;

        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
            maxSoFar = Math.max(maxCur, maxSoFar);
        }

        return maxSoFar;
    }
}
