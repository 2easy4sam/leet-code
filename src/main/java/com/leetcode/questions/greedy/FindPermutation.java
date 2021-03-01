package com.leetcode.questions.greedy;

public class FindPermutation {

    public int[] findPermutation(String s) {
        /*
        - test cases:
            -          I D I
                arr: [1,2,3,4]

                i           secret          arr
                0           I               [1,2,3,4]
                1           D               [1,3,2,4]
                2           I               [1,3,2,4]
            -          I D I D
                arr: [1,2,3,4,5]

                i           secret          arr
                0           I               [1,2,3,4,5]
                1           D               [1,3,2,4,5]
                2           I               [1,3,2,4,5]
                3           D               [1,3,2,5,4]
        - constraints/key words:
            - lexicographically smallest
        - thinking out loud:
            - the size of the array is s.length() + 1
            - we need to generate an array with nums from 1 to n (inclusive) sorted in ascending order
            - whenever a 'D' is found at i, reverse arr[i] and arr[i + 1]
            - whenever an 'I' is found, continue the loop
        - time and space complexity:
            - time:
            - space:
        */

        int n = s.length();
        int[] arr = new int[n + 1];

        /*
        create array with numbers 1 - n (inclusive)
        */
        for (int i = 0; i <= n; i++) arr[i] = i + 1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') continue;
            int l = i, r = i;
            while (s.charAt(i++) == 'D') r++;
            reverse(arr, l, r);
        }

        return arr;
    }

    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int tmp = arr[r];
            arr[r--] = arr[l];
            arr[l++] = tmp;
        }
    }
}
