package com.assignment1;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String s: words) {
            if (!frequency.containsKey(s)) {
                frequency.put(s, 1);
            }else {
                frequency.put(s, frequency.get(s) + 1);
            }
        }
        ArrayList<String> keys = new ArrayList<>(frequency.keySet());
        keys.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (!Objects.equals(frequency.get(o1), frequency.get(o2))) {
                    return frequency.get(o2) - frequency.get(o1);
                }
                return o1.compareTo(o2);
            }
        });

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(keys.get(i));
        }
        return result;
    }

}
