package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class PlayWithChips {
    public int minCostToMoveChips(int[] chips) {
        Map<Integer, Integer> posChipCountMap = new HashMap<>();

        for (int chip : chips) {
            if (posChipCountMap.containsKey(chip)) {
                posChipCountMap.put(chip, posChipCountMap.get(chip) + 1);
            } else {
                posChipCountMap.put(chip, 1);
            }
        }

        int minCost = 0;
        Integer[] positions = posChipCountMap.keySet().toArray(new Integer[0]);

        for (int i = 0; i < positions.length; i++) {
            int cost = 0;

            for (int j = 0; j < positions.length; j++) {
                if (!positions[i].equals(positions[j])) {
                    int diff = Math.abs(positions[i] - positions[j]);

                    if (diff % 2 != 0) {
                        cost += posChipCountMap.get(positions[j]);
                    }
                }
            }

            if (i == 0) {
                minCost = cost;
            } else if (cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }
}
