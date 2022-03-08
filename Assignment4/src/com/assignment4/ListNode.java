package com.assignment4;

import java.sql.SQLOutput;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        this.val = 0;
    }

    public ListNode(int value) {
        val = value;
    }

    public ListNode(int value, ListNode nextPointer) {
        val = value;
        next = nextPointer;
    }

    public static void showList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
}
