package com.assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static void main(String[] args) {
        int[] testCase1 = {0, 0, 0, 0};

        fourSum(testCase1, 0);
    }
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return nSum(nums, target, 4, 0);
        }

        public static List<List<Integer>> nSum(int[] nums, int target, int n, int start) {
            if (n <= 2) {
                return twoSum(nums, target, 2, start);
            }

            List<List<Integer>> result = new ArrayList<>();
            for (int i = start; i < nums.length - n + 1; i++) {
                List<List<Integer>> temp = nSum(nums, target - nums[i], n - 1, i + 1);
                for (List<Integer> integers : temp) {
                    integers.add(nums[i]);
                    result.add(integers);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }

            return result;

        }

        public static List<List<Integer>> twoSum(int[] nums, int target, int n, int start) {
            int left = start;
            int right = nums.length - 1;
            List<List<Integer>> result = new ArrayList<>();

            while (left < right) {
                int leftVal = nums[left];
                int rightVal = nums[right];

                if (leftVal + rightVal == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(leftVal);
                    temp.add(rightVal);
                    result.add(temp);
                    while (left < right && nums[left] == leftVal){
                        left++;
                    }
                    while (left < right && nums[right] == rightVal) {
                        right--;
                    }
                }else if (leftVal + rightVal > target) {
                    while (left < right && nums[right] == rightVal) {
                        right--;
                    }
                }else if (leftVal + rightVal < target) {
                    while (left < right && nums[left] == leftVal) {
                        left++;
                    }
                }
            }

            return result;
        }
    }

