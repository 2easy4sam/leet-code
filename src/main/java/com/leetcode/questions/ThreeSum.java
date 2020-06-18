package com.leetcode.questions;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) return res;

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i <= n - 3; i++) {
            int j = i + 1, k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        res.addAll(set);
        return res;
    }

    private boolean binarySearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0, hi = n - 1;

        while (low <= hi) {
            int mid = (low + hi) / 2;

            if (arr[mid] == target) return true;
            else if (arr[mid] < target) low = mid + 1;
            else hi = mid - 1;
        }

        return false;
    }
}
