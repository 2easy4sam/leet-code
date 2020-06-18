package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {
    private final int size;
    private List<Integer> vals;

    public MovingAverage(int size) {
        this.size = size;
        this.vals = new ArrayList<>();
    }

    public double next(int val) {
        vals.add(val);
        int sum = 0;
        int denominator = Math.min(vals.size(), size);

        for (int i = vals.size() > size ? vals.size() - size : 0; i < vals.size(); i++) {
            sum += vals.get(i);
        }

        return (double) sum / denominator;
    }
}
