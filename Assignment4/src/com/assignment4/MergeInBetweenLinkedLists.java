package com.assignment4;

public class MergeInBetweenLinkedLists {
    // T/S = O(n) / O(1)
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        ListNode end = list1;

        while ((a > 1 || b > -1) && end != null) {
            if (a > 1) {
                a--;
                start = start.next;
            }
            if (b > -1) {
                b--;
                end = end.next;
            }
        }

        //System.out.println(end.val);

        start.next = list2;
        ListNode p = list2;

        while (p.next != null) {
            p = p.next;
        }

        p.next = end;

        return list1;
    }
}
