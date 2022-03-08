package com.assignment4;

import java.util.HashSet;

public class LinkListComponent {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        ListNode p = head;
        int result = 0;

        while (p != null) {
            if (numSet.contains(p.val)) {
                result += 1;
                while (p != null && numSet.contains(p.val)) {
                    p = p.next;
                }
            }
            if (p != null) p = p.next;
        }

        return result;
    }
}
