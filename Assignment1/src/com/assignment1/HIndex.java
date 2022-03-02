package com.assignment1;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int[] testCase1 = {3,0,6,1,5};
        int[] testCase2 = {1,3,1};

        System.out.println(getHIndex(testCase1));
        System.out.println(getHIndex(testCase2));
    }

    // TimeComplexity: O(n * n);
    // SpaceComplexity: O(1)
    public static int getHIndex(int[] arr) {
        if (arr == null) return -1;

        arr = selectedSort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 >= arr[i]) {
                return arr[i];
            }
        }

        return -1;
    }

    public static int[] selectedSort(int[] arr) {
        if (arr.length == 0) return null;
        for (int i = 0; i < arr.length - 1; i++) {
            int maxValue = Integer.MIN_VALUE;
            int maxIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > maxValue) {
                    maxValue = arr[j];
                    maxIndex = j;
                }
            }
            swap(i, maxIndex, arr);
        }

        return arr;
    }

    public static void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
