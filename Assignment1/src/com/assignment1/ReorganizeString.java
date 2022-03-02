package com.assignment1;

import java.util.*;

public class ReorganizeString {

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aaab";

        System.out.println(reorganizeString(s1));
        System.out.println(reorganizeString(s2));
    }

    public static String reorganizeString(String s) {
        if (s == null) return null;
        HashMap<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!strMap.containsKey(s.charAt(i))) {
                strMap.put(s.charAt(i), 1);
            }else {
                int times = strMap.get(s.charAt(i)) + 1;
                strMap.put(s.charAt(i), times);
            }
        }
        ArrayList<Character> keyArray = new ArrayList<>(strMap.keySet());
        keyArray.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return strMap.get(o2) - strMap.get(o1);
            }
        });
        if (strMap.get(keyArray.get(0)) > Math.ceil((double)s.length() / 2)) return "";
        int index = 0;
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i += 2) {
            Character key = keyArray.get(index);
            if (strMap.get(key) == 0 ) {
                index++;
                key = keyArray.get(index);
            }
            result[i] = key;
            strMap.put(key, strMap.get(key) - 1);
        }
        for (int i = 1; i < s.length(); i+=2) {
            Character key = keyArray.get(index);
            if (strMap.get(key) == 0 ) {
                index++;
                key = keyArray.get(index);
            }
            result[i] = key;
            strMap.put(key, strMap.get(key) - 1);
        }
        //System.out.println(Arrays.toString(result));
        StringBuilder res = new StringBuilder();
        for (Character c: result) {
            res.append(c);
        }
        return res.toString();
    }
}
