package com.assignment1;

import java.sql.Array;
import java.util.*;

public class IntersectionOfTwoArray349 {
    public static void main(String[] args) {
        int[] testCase1_1 = {1,2,2,1};
        int[] testCase1_2 = {2,2};

        int[] testCase2_1 = {4,9,5};
        int[] testCase2_2 = {9,4,9,8,4};

        System.out.println(intersection(testCase1_1, testCase1_2).toString());
        System.out.println(intersection(testCase2_1, testCase2_2).toString());
    }

    public static List<Integer> intersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }
        for (int num: arr2) {
            set2.add(num);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }
}
