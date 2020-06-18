package com.leetcode.questions;

import java.util.Arrays;

public class MakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int res = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) res++;
        }

        return res;
    }
}
