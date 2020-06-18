package com.leetcode.questions.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The power of an integer x is defined as the number of steps needed
 * to transform x into 1 using the following steps:
 * <p>
 * if x is even then x = x / 2
 * if x is odd then x = 3 * x + 1
 * For example, the power of x = 3 is 7 because 3 needs 7 steps to
 * become 1 (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).
 * <p>
 * Given three integers lo, hi and k. The task is to sort all integers
 * in the interval [lo, hi] by the power value in ascending order, if
 * two or more integers have the same power value sort them by
 * ascending order.
 * <p>
 * Return the k-th integer in the range [lo, hi] sorted by the power
 * value.
 * <p>
 * Notice that for any integer x (lo <= x <= hi) it is guaranteed
 * that x will transform into 1 using these steps and that the power
 * of x is will fit in 32 bit signed integer.
 */
public class SortIntegersByThePowerValue {
    private static class Pair {
        int key, value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getKth(int lo, int hi, int k) {
        // we know that no matter what number we start off with
        // we will eventually arrive at 1, which takes 0 steps

        // number <-> steps
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);

        List<Pair> list = new ArrayList<>();

        for (int i = 1; i <= hi; i++) {
            count(i, map);
            if (i >= lo) list.add(new Pair(i, map.get(i)));
        }

        list.sort((e1, e2) -> e1.value == e2.value
                ? e1.key - e2.key
                : e1.value - e2.value);

        return list.get(k - 1).key;
    }

    private int count(int num, Map<Integer, Integer> map) {
        if (map.containsKey(num)) return map.get(num);

        int n = (num & 1) == 1
                ? count(num * 3 + 1, map)
                : count(num / 2, map);
        map.put(num, n + 1);
        return map.get(num);
    }
}
