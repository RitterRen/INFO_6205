package com.midterm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        int[] nums1 = {0,1,3,50,75};
        int lower1 = 0;
        int upper1 = 99;
        System.out.println(question1(nums1, lower1, upper1).toString());

        int[] nums2 = {-1};
        int lower2 = -1;
        int upper2 = -1;
        System.out.println(question1(nums2, lower2, upper2).toString());
    }

    public static List<String> question1(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        List<Integer> numbers = new ArrayList<>();
        boolean lowerFlag = false;

        // add the lower and upper number into the nums list
        for (int num : nums) {
            if (!lowerFlag && num >= lower) {
                numbers.add(lower);
                lowerFlag = true;
                if (num > lower) numbers.add(num);
            } else if (num > lower && num < upper) numbers.add(num);
            else if (num >= upper) {
                numbers.add(upper);
                break;
            }
        }
        if (upper > nums[nums.length - 1]) numbers.add(upper);

        // traverse the numbers list and get the result
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i + 1) - numbers.get(i) == 2) {
                result.add(String.valueOf(numbers.get(i) + 1));
            }else if (numbers.get(i + 1) - numbers.get(i) > 2) {
                String temp = "";
                if (numbers.get(i + 1) == upper) {
                    temp = String.valueOf(numbers.get(i) + 1) + "->" + String.valueOf(numbers.get(i + 1));
                }else {
                    temp = String.valueOf(numbers.get(i) + 1) + "->" + String.valueOf(numbers.get(i + 1) - 1);
                }
                result.add(temp);
            }
        }

        return result;
    }
}
