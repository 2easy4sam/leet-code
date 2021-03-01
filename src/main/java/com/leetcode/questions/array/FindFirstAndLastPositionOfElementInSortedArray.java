package com.leetcode.questions.array;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                int start = mid, end = mid;

                while (start > 0 && nums[start] == target) {
                    start--;
                }

                while (end < nums.length && nums[end] == target) {
                    end++;
                }

                return new int[]{start + 1, end - 1};
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
