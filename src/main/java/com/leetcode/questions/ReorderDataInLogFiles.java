package com.leetcode.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class ReorderDataInLogFiles {
    private static final String DELIMITER = " ";

    public String[] reorderLogFiles(String[] logs) {
        final int len = logs.length;

        // find all indices of digit-logs
        Stack<Integer> indices = new Stack<>();

        int i = 0;

        while (i < len) {
            if (isDigitLog(logs[i])) indices.add(i);
            i++;
        }

        i = len - 1;
        while (!indices.isEmpty()) {
            int index = indices.pop();
            String tmp = logs[i];
            logs[i] = logs[index];
            logs[index] = tmp;
            i--;
        }

        // sort the letter-logs
        mergeSort(logs, 0, i);

        return logs;
    }

    private boolean isDigitLog(String log) {
        return Character.isDigit(log.split(DELIMITER)[1].charAt(0));
    }

    private void mergeSort(String[] arr, int begin, int end) {
        if (begin < end) {
            int mid = begin + (end - begin) / 2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, begin, mid, end);
        }
    }

    private void merge(String[] arr, int begin, int mid, int end) {
        // copy data to left and right arrays
        int len1 = mid - begin + 1;
        int len2 = end - mid;

        // create 2 empty arrays to copy data over
        String[] left = new String[len1];
        String[] right = new String[len2];

        // copy data
        for (int i = 0; i < len1; i++) {
            left[i] = arr[i + begin];
        }

        for (int i = 0; i < len2; i++) {
            right[i] = arr[i + mid + 1];
        }

        // merge arrays into arr
        int idx = begin;    // index for arr
        int l = 0, r = 0;

        while (l < len1 && r < len2) {
            if (isLexicographicallyGreater(left[l], right[r])) {
                arr[idx] = right[r];
                r++;
            } else {
                arr[idx] = left[l];
                l++;
            }

            idx++;
        }

        // copy remainders
        while (l < len1) {
            arr[idx] = left[l];
            idx++;
            l++;
        }

        while (r < len2) {
            arr[idx] = right[r];
            idx++;
            r++;
        }
    }

    private boolean isLexicographicallyGreater(String s1, String s2) {
        s1 = s1.split(DELIMITER)[1];
        s2 = s2.split(DELIMITER)[1];

        int i = 0;

        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) i++;
            else return s1.charAt(i) > s2.charAt(i);
        }

        return s1.length() > s2.length();
    }

    public String[] reorderLogFiles2(String[] logs) {
        Comparator<String> myComp = (s1, s2) -> {
            int s1SpaceIdx = s1.indexOf(' ');
            int s2SpaceIdx = s2.indexOf(' ');
            char s1FirstChar = s1.charAt(s1SpaceIdx + 1);
            char s2FirstChar = s2.charAt(s2SpaceIdx + 1);

            if (s1FirstChar <= '9') {
                if (s2FirstChar <= '9') return 0;
                else return 1;
            }
            if (s2FirstChar <= '9') return -1;

            int preCompute = s1.substring(s1SpaceIdx + 1).compareTo(s2.substring(s2SpaceIdx + 1));
            if (preCompute == 0) return s1.substring(0, s1SpaceIdx).compareTo(s2.substring(0, s2SpaceIdx));
            return preCompute;
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
