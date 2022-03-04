package com.assignment2;

import java.util.Arrays;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPointer = 0;
        int endPointer = 0;
        int result = 0;
        int rooms = 0;

        while (startPointer < intervals.length && endPointer < intervals.length) {
            if (startTimes[startPointer] < endTimes[endPointer]) {
                rooms++;
                result = Math.max(rooms, result);
                startPointer++;
            }else {
                rooms--;
                endPointer++;
            }
        }
        return result;
    }
}
