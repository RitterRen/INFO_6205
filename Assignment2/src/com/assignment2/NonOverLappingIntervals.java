package com.assignment2;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverLappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // greedy
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int minRight = intervals[0][1];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < minRight) {
                result += 1;
            }else {
                minRight = intervals[i][1];
            }
        }

        return result;
    }
}
