package com.leetcode.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a m * n matrix of distinct numbers,
 * return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is
 * the minimum element in its row and maximum in its column.
 */
public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        // since all elems are distinct/unique, it is a matter
        // of finding the intersection minSet and maxSet
        Set<Integer> minSet = new HashSet<>(),
                maxSet = new HashSet<>();

        for (int[] row : matrix) {
            int mi = row[0];
            for (int cell : row)
                mi = Math.min(mi, cell);
            minSet.add(mi);
        }

        for (int j = 0; j < matrix[0].length; ++j) {
            int mx = matrix[0][j];

            for (int i = 0; i < matrix.length; ++i) {
                mx = Math.max(matrix[i][j], mx);
                if (minSet.contains(mx)) maxSet.add(mx);
            }
        }
        return new ArrayList<>(maxSet);
    }
}
