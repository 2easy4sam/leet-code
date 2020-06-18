package com.leetcode.questions;

public class RelativeArraySort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index = 0;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    int temp = arr1[index];
                    arr1[index++] = arr2[i];
                    arr1[j] = temp;
                }
            }
        }

        // sort remaining
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = index; i < arr1.length - 1; i++) {
                if (arr1[i] > arr1[i + 1]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + 1];
                    arr1[i + 1] = temp;
                    swapped = true;
                }
            }
        }

        return arr1;
    }
}