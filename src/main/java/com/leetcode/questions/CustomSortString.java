package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String S, String T) {
        int[] charIndices = new int[26];
        Map<Integer, Character> reverseLookupMap = new HashMap();

        // get the index of every character in S
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int idx = i + 1;
            charIndices[c - 'a'] = idx;
            reverseLookupMap.put(idx, c);
        }

        int len = T.length();
        char[] res = new char[len];
        int j = 0, k = len - 1;

        // put all character that doesn't occur in S at the end
        for (int i = 0; i < len; i++) {
            char c = T.charAt(i);
            if (charIndices[c - 'a'] == 0) res[k--] = c;
            else {
                res[j++] = (char) charIndices[c - 'a'];
            }
        }

        if (k == 0) return T;

        // sort the array up to index j
        mergeSort(res, 0, k);

        // replace indices with characters
        for (int i = 0; i <= k; i++) {
            res[i] = reverseLookupMap.get((int) res[i]);
        }

        return new String(res);
    }

    private void mergeSort(char[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(char[] arr, int l, int m, int r) {
        // left would always include the mid point
        int n1 = m - l + 1;
        int n2 = r - m;

        // copy elements to left
        char[] left = new char[n1];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[i + l];
        }

        // copy elements to right
        char[] right = new char[n2];
        for (int i = 0; i < n2; i++) {
            right[i] = arr[i + m + 1];
        }

        // compare elements in both arrays
        int k = l, i = 0, j = 0;

        while (i < n1 && j < n2) {
            if ((int) left[i] <= (int) right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // fill up with left-overs
        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}
