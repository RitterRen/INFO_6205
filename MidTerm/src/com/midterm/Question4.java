package com.midterm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Question4 {
    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        showIntervals(question4(intervals1));
        int[][] intervals2 = {{1, 4}, {4, 5}};
        showIntervals(question4(intervals2));
    }

    public static List<int[]> question4(int[][] intervals) {
        List<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int i = 0;
        while (i < intervals.length) {
            if (i < intervals.length - 1 && intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
            }else {
                result.add(intervals[i]);
            }
            i++;
        }

        return result;
    }

    private static void showIntervals(List<int[]> result) {
        for (int[] item: result) {
            System.out.print(Arrays.toString(item) + " ");
        }
    }
}
