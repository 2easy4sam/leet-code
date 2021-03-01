package com.leetcode.questions.array;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        /*
        - test cases:
            -   [1,2,3]
                [4,5,6]
                [7,8,9]
            number          reverse         list            size
            1               false           [1]             0
            4               true            [1,4]           1
            2               true            [1,2,4]         1
            7               false           [1,2,4,7]       3
            5               false           [1,2,4,7,5]     3
            3               false           [1,2,4,7,5,3]   3


        - thinking out loud:
            - traverse along the left and bottom edges
            - at each cell, traverse diagonally
        */

        int m = matrix.length, n = matrix[0].length;

        List<Integer> list = new ArrayList<>();
        boolean reverse = false;
        // right border
        for (int i = 0; i < m; i++) {
            traverse(matrix, list, reverse, list.size(), i, 0);
            reverse = !reverse;
        }

        // bottom border
        for (int j = 1; j < n; j++) {
            traverse(matrix, list, reverse, list.size(), m - 1, j);
            reverse = !reverse;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void traverse(int[][] mat, List<Integer> list, boolean reverse, int idx, int i, int j) {
        if (i < 0 || i > mat.length - 1 || j < 0 || j > mat[0].length - 1)
            return;

        if (reverse) {
            list.add(idx, mat[i][j]);
        } else {
            list.add(mat[i][j]);
        }

        traverse(mat, list, reverse, idx, i - 1, j + 1);
    }
}
