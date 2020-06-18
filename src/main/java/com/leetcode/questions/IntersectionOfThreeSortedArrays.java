package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly
 * increasing order, return a sorted array of only the integers that
 * appeared in all three arrays.
 */
public class IntersectionOfThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1,
                                            int[] arr2,
                                            int[] arr3) {
        List<Integer> intersection = new ArrayList<>();

        // given that the 3 arrays are sorted in ascending order,
        // i.e. the smallest number at the head and largest number at
        // the tail we can find the smallest number that all 3 arrays
        // have in common in each iteration
        int a = 0, b = 0, c = 0;

        while (a < arr1.length
                && b < arr2.length
                && c < arr3.length) {
            int min = Math.min(arr1[a], Math.min(arr2[b], arr3[c]));

            if (arr1[a] == arr2[b] && arr2[b] == arr3[c]) {
                intersection.add(min);
            }
            if (arr1[a] == min) a++;
            if (arr2[b] == min) b++;
            if (arr3[c] == min) c++;
        }

        return intersection;
    }
}
