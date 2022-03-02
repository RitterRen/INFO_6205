package com.assignment1;

import java.util.Arrays;
import java.util.List;

public class FindKClosestElement {
    public static void main(String[] args) {
        int[] testCase1 = {1,2,3,4,5};
        int target1 = 3;
        int k1 = 4;
        int[] testCase2 = {1,2,3,4,5};
        int target2 = -1;
        int k2 = 4;

        System.out.println(Arrays.toString(findKClosestElement(testCase1, target1, k1)));
        System.out.println(Arrays.toString(findKClosestElement(testCase2, target2, k2)));
    }

    public static int[] findKClosestElement(int[] arr, int target, int k) {
        // 1. find the closest element;
        // 2. Double Pointer;
        int targetIndex = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int tempDiff = Math.abs(target - arr[i]);
            if (tempDiff < diff) {
                targetIndex = i;
                diff = tempDiff;
            }
        }

        System.out.println(targetIndex);

        int left = targetIndex;
        int right = targetIndex;

        while (right - left + 1 < k) {
            if (left > 0 && Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
                left--;
            }else {
                right++;
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[left + i];
        }

        return result;
    }
}
