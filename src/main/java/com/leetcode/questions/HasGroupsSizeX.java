package com.leetcode.questions;

import java.util.Arrays;

public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        int length = deck.length;

        deck = Arrays.stream(deck)
                .boxed()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 2; i <= length; i++) {
            if (length % i == 0) {
                int count = 0;

                for (int j = 0; j <= length - i; j += i) {
                    if (deck[j] == deck[j + i - 1]) count++;
                }

                if (count == length / i) return true;
            }
        }

        return false;
    }
}
