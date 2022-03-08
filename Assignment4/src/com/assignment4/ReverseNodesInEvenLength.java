package com.assignment4;

import java.sql.SQLOutput;

public class ReverseNodesInEvenLength {
    public static void main(String[] args) {
        int[] testCase1 = {1, 2, 3, 4, 5};
        ListNode head1 = new ListNode(testCase1[0]);
        ListNode p = head1;

        for (int i = 1; i < testCase1.length; i++) {
            p.next = new ListNode(testCase1[i]);
            p = p.next;
        }

        ListNode newHead = reverseEvenLengthGroups(head1);
        showLinkedList(newHead);
    }

    public static ListNode reverseEvenLengthGroups(ListNode head) {
        int index = 1;
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode post = cur;

        while (cur != null) {
            int temp = index;
            int length = 0;
            while (temp > 0 && post != null) {
                post = post.next;
                length++;
                temp--;
            }
            System.out.println(index);
            if (length %  2 == 0 && length > 1) {
                cur = reverseLinkedList(cur, post, length);
                System.out.println(cur.val);
            }
            pre.next = cur;
            temp = index;
            while (temp > 0 && pre != null) {
                pre = pre.next;
                temp--;
            }

            cur = post;
            index++;
        }

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

    private static void showLinkedList(ListNode head) {
        ListNode p = head;

        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
}
