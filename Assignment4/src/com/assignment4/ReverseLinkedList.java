package com.assignment4;

import java.util.Arrays;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] testCase1 = {1,2,3,4,5};
        ListNode head1 = new ListNode(testCase1[0]);
        ListNode p = head1;

        for (int i = 1; i < testCase1.length; i++) {
            p.next = new ListNode(testCase1[i]);
            p = p.next;
        }

        ListNode newHead = reverseBetween(head1, 2, 4);
        ListNode.showList(newHead);

    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int length = right - left + 1;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;

        while ((left > 1 || right > 0) && cur != null) {
            if (left > 1) pre = pre.next;
            if (right > 1) {
                cur = cur.next;
            }else if (right == 1) {
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }
            left--;
            right--;
        }

        pre.next = reverseLinkedList(pre.next, cur, length);

        return dummyHead.next;


    }

    private static ListNode reverseLinkedList(ListNode head, ListNode tail, int length) {
        ListNode pre = tail;
        ListNode cur = head;

        while (cur != null && length > 0) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            length--;
        }

        return pre;
    }
}
