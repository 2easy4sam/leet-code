package com.leetcode.questions;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] nums = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int a = secret.charAt(i) - '0';
            int b = guess.charAt(i) - '0';

            if (a == b) {
                bulls++;
            } else {
                if (nums[a] < 0) cows++;
                if (nums[b] > 0) cows++;
                nums[a]++;
                nums[b]--;
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }
}
