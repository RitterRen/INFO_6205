package com.assignment1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public static void main(String[] args) {
        int[] testcase1 = {3,2,4,1};
        int[] testcase2 = {1,2,3};

        System.out.println(pancakeSorting(testcase1).toString());
        System.out.println(pancakeSorting(testcase2).toString());
    }

    public static List<Integer> pancakeSorting(int[] arr) {
        if (arr == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == i + 1) continue;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] == i + 1) {
                    result.add(j + 1);
                    reverse(0, j, arr);
                    result.add(i + 1);
                    reverse(0, i, arr);
                }
            }
        }

        return result;
    }

    public static void reverse(int left, int right, int[] arr) {
        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }
}
