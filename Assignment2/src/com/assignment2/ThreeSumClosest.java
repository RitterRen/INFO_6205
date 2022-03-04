package com.assignment2;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(total - target);
                if (diff < minDiff) {
                    result = total;
                    minDiff = diff;
                }
                if (total - target > 0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
}
