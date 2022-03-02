package com.assignment1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CustomSortString {
    public static void main(String[] args) {
        String s1 = "abcd";
        String order1 = "cba";

        String s2 = "abcd";
        String order2 = "cbafg";

        System.out.println(customSortString(order1, s1));
        System.out.println(customSortString(order2, s2));
    }

    public static String customSortString(String order, String s) {
        HashMap<Character, Integer> weight = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            Character key = order.charAt(i);
            weight.put(key, i);
        }
        Character[] result = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
            if (!weight.containsKey(s.charAt(i))) {
                weight.put(s.charAt(i), 26);
            }
        }
        Arrays.sort(result, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return weight.get(o1) - weight.get(o2);
            }
        });
        return stringToArray(result);
    }

    public static String stringToArray(Character[] array) {
        StringBuilder result = new StringBuilder();
        for (Character c : array) {
            result.append(c);
        }

        return result.toString();
    }
}
