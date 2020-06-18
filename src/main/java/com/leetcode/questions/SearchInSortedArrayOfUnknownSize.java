package com.leetcode.questions;

class SearchInSortedArrayOfUnknownSize {
    static class ArrayReader {
        private final int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        int get(int idx) {
            if (idx >= arr.length || idx < 0) return Integer.MAX_VALUE;
            return arr[idx];
        }
    }

    int search2(ArrayReader reader, int target) {
        int i = 0, j = 9999 * 2 + 1, m = (i + j) / 2;

        while (i <= j) {
            int num = reader.get(m);

            if (num == target) return m;
            else if (num > target) j = m - 1;
            else i = m + 1;

            m = (i + j) / 2;
        }

        return -1;
    }

    /**
     * This method employs bitwise shift to find the lower and upper bounds
     * Which in theory should reduce the runtime
     */
    int search(ArrayReader reader, int target) {
        int max = 1;

        while (reader.get(max) < target) {
            max = max << 1;
        }

        int min = max >> 1;
        int m = (min + max) / 2;

        while (min <= max) {
            if (reader.get(m) == target) return m;
            else if (reader.get(m) > target) max = m - 1;
            else min = m + 1;

            m = (min + max) / 2;
        }

        return -1;
    }
}
