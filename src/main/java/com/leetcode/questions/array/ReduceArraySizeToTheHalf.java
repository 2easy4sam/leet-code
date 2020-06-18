package com.leetcode.questions.array;

import java.util.Arrays;

public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        int[] cnt = new int[100001];
        for (int num : arr) cnt[num]++;
        Arrays.sort(cnt);
        int sum = 0, size = 0;
        for (int i = cnt.length - 1; sum < arr.length && i >= 0; i--) {
            sum += cnt[i];
            size++;
        }

        return size;
    }
}
