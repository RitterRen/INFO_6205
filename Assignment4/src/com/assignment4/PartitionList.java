package com.assignment4;

public class PartitionList {
    // T/S = O(n)/O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0); // dummyHead
        ListNode largeHead = new ListNode(0); // dummyHead
        ListNode small = smallHead;
        ListNode large = largeHead;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                small.next = p;
                small = small.next;
            }else {
                large.next = p;
                large = large.next;
            }

            p = p.next;
        }
        large.next = null;

        //showList(smallHead);
        //showList(largeHead);

        small.next = largeHead.next;

        return smallHead.next;

    }

    private void showList(ListNode head) {
        ListNode p = head;

        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }

        System.out.println();
    }
}
