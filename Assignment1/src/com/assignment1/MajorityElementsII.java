package com.assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElementsII {

    public static void main(String[] args) {
        int[] testCase1 = {3,2,3};
        int[] testCase2 = {1};
        int[] testCase3 = {1, 2};

        System.out.println(findMajorityElements(testCase1).toString());
        System.out.println(findMajorityElements(testCase2).toString());
        System.out.println(findMajorityElements(testCase3).toString());
    }

    public static List<Integer> findMajorityElements(int[] arr) {
        HashMap<Integer, Integer> timesTable = new HashMap<>();
        int target = (int) Math.floor(arr.length / 3);

        for (int num : arr) {
            if (timesTable.containsKey(num)) {
                int newTimes = timesTable.get(num) + 1;
                timesTable.put(num, newTimes);
            }else {
                timesTable.put(num, 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int key : timesTable.keySet()) {
            int times = timesTable.get(key);
            if (times > target) {
                result.add(key);
            }
        }

        return result;
    }
}
