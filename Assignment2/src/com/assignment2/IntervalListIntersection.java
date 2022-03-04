package com.assignment2;

import java.util.ArrayList;

public class IntervalListIntersection {
    public static void main(String[] args) {
        System.out.println();
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> temp = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                int[] array = {start, end};
                temp.add(array);
            }
            if (firstList[i][1] > secondList[j][1]) {
                j++;
            }else {
                i++;
            }
        }

        int[][] result = new int[temp.size()][];
        for (int k = 0; k < temp.size(); k++) {
            result[k] = temp.get(k);
        }

        return result;
    }
}
