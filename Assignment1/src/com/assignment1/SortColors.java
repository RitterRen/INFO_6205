package com.assignment1;

import java.sql.SQLOutput;
import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        // test the solution
        int[] case1 = {2,0,2,1,1,0};
        int[] case2 = {2,0,1};

        System.out.println(Arrays.toString(sortColors(case1)));
        System.out.println(Arrays.toString(sortColors(case2)));
    }

    public static int[] sortColors(int[] arr) {
        if (arr == null) return null;

        int leftRegion = -1;
        int rightRegion = arr.length;
        int i = 0;

        while (i < rightRegion) {
            if (arr[i] < 1) {
                swap(leftRegion + 1, i, arr);
                leftRegion++;
                i++;
            }else if (arr[i] > 1) {
                swap(rightRegion - 1, i, arr);
                rightRegion--;
            }else { // arr[i] == 1
                i++;
            }
        }

        return arr;
    }

    public static void swap(int l1, int l2, int[] arr) {
        if (l1 == l2) return;

        int temp = arr[l1];
        arr[l1] = arr[l2];
        arr[l2] = temp;
    }
}
