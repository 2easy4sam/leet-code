package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1); // there is at least one element

        for (int i = 1; i <= rowIndex; i++) {
            int prev = row.get(0);

            for (int j = 1; j < i; j++) {
                int newVal = prev + row.get(j);
                prev = row.get(j);
                row.set(j, newVal);
            }

            row.add(1);
        }

        return row;
    }
}
