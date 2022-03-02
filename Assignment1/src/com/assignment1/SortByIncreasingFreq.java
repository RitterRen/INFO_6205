package com.assignment1;

import java.util.*;

public class SortByIncreasingFreq {
    public static void main(String[] args) {

    }

    public static int[] frequencySort(int[] arr) {
        if (arr == null) return null;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        Integer[] result = new Integer[arr.length];
        int i = 0;
        for (int num: arr) {
            result[i] = num;
            i++;
            if (!frequency.containsKey(num)) {
                frequency.put(num, 1);
            }else {
                frequency.put(num, frequency.get(num) + 1);
            }
        }


        Arrays.sort(result, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if (!Objects.equals(frequency.get(o1), frequency.get(o2))) {
                    return frequency.get(o1) - frequency.get(o2);
                }
                return o2 - o1;
            }
        });
        i = 0;
        for (int num: result) {
            arr[i] = result[i];
            i++;
        }
        return arr;
    }
}
