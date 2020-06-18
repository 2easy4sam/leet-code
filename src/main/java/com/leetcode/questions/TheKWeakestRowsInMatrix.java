package com.leetcode.questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a m * n matrix mat of ones (representing soldiers) and zeros
 * (representing civilians), return the indexes of the k weakest rows
 * in the matrix ordered from the weakest to the strongest.
 *
 * A row i is weaker than row j, if the number of soldiers in row i is
 * less than the number of soldiers in row j, or they have the same
 * number of soldiers but i is less than j. Soldiers are always stand
 * in the frontier of a row, that is, always ones may appear first
 * and then zeros.
 */
public class TheKWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[] weakest = new int[k];
        Map<Integer, Integer> rowSoldierMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int nSoldiers = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) nSoldiers++;
            }

            rowSoldierMap.put(i, nSoldiers);
        }

        List<Integer> list = rowSoldierMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (int i = 0; i < k; i++) {
            weakest[i] = list.get(i);
        }

        return weakest;
    }
}
