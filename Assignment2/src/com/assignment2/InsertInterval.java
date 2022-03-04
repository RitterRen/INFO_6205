package com.assignment2;

import java.util.ArrayList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        ArrayList<int[]> temp = new ArrayList<>();

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            temp.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        temp.add(newInterval);

        while (i < intervals.length) {
            temp.add(intervals[i++]);
        }

        int[][] result = new int[temp.size()][];
        for (int k = 0; k < temp.size(); k++) {
            result[k] = temp.get(k);
        }

        return result;
    }
}
