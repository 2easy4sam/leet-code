package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
    private static final Map<Integer, Integer> FIBONACCI_MAP = new HashMap<Integer, Integer>(30) {
        {
            put(0, 0);
            put(1, 1);
        }
    };

    public int fib(int N) {
        if (N < 2) return FIBONACCI_MAP.get(N);

        int temp = N - 2;

        while (FIBONACCI_MAP.get(N - 1) == null) {
            if (FIBONACCI_MAP.get(temp) != null) {
                FIBONACCI_MAP.put(++temp, FIBONACCI_MAP.get(temp - 1) + FIBONACCI_MAP.get(temp - 2));
            } else {
                temp--;
            }
        }

        return FIBONACCI_MAP.get(N - 1) + FIBONACCI_MAP.get(N - 2);
    }
}
