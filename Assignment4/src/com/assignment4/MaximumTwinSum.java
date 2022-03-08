package com.assignment4;

import java.util.ArrayList;

public class MaximumTwinSum {
    public int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode p = head;

        while (p != null) {
            arr.add(p.val);
            p = p.next;
        }

        int left = 0;
        int right = arr.size() - 1;
        int result = 0;

        while (left < right) {
            result = Math.max(result, arr.get(left) + arr.get(right));
            left++;
            right--;
        }

        return result;

    }
}
