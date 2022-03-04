package com.assignment2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFreqElement {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num: nums) {
            if (!frequency.containsKey(num)) {
                frequency.put(num, 1);
            }else {
                frequency.put(num, frequency.get(num) + 1);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return frequency.get(o2) - frequency.get(o1);
            }
        });
        priorityQueue.addAll(frequency.keySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (priorityQueue.size() > 0) {
                result[i] = priorityQueue.poll();
            }
        }

        return result;
    }
}
