package com.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortList {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode p = head;

        while (p != null) {
            arr.add(p.val);
            p = p.next;
        }
        Collections.sort(arr);

        ListNode dummyHead = new ListNode(0);
        p = dummyHead;

        for (int value: arr) {
            p.next = new ListNode(value);
            p = p.next;
        }

        return dummyHead.next;
    }
}
