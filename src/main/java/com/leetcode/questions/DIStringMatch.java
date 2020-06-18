package com.leetcode.questions;

public class DIStringMatch {
    public int[] diStringMatch(String S) {
        if (S.replaceAll("D", "").isEmpty()) return createDecreasingArray(S.length() + 1);

        int[] arr = createIncreasingArray(S.length() + 1);

        if (S.replaceAll("I", "").isEmpty()) return arr;

        boolean swapped = true;

        while (swapped) {
            swapped = false;

            // iterate through the string, and compare adjacent ints
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);

                if ((c == 'D' && arr[i] < arr[i + 1])
                        || (c == 'I' && arr[i] > arr[i + 1])) {
                    swap(arr, i, i + 1);
                    swapped = true;
                    break;
                }
            }
        }

        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int[] createDecreasingArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = size - 1 - i;
        }

        return array;
    }

    private int[] createIncreasingArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        return array;
    }
}
