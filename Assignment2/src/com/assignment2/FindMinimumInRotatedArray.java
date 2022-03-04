package com.assignment2;

public class FindMinimumInRotatedArray {
    public int findMin(int[] nums) {
        //boolean flag = false;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] > nums[i] && nums[i + 1] > nums[i]) {
                return nums[i];
            }
        }

        return Math.min(nums[0], nums[nums.length - 1]);
    }

    public int findMin2(int[] nums) {
        //boolean flag = false;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return nums[left];
    }
}
