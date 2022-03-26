package com.midterm;

import java.util.List;

public class Question2 {
    public static void main(String[] args) {

    }

    public static ListNode question2(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        int carry = 0;

        while (p1 != null && p2 != null) {
            int temp = p1.val + p2.val + carry;
            carry = 0;
            if (temp > 9) {
                temp %= 10;
                carry = 1;
            }
            p.next = new ListNode(temp);
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int temp = p1.val + carry;
            carry = 0;
            if (temp > 9) {
                temp %= 10;
                carry = 1;
            }
            p.next = new ListNode(temp);
            p = p.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int temp = p2.val + carry;
            carry = 0;
            if (temp > 9) {
                temp %= 10;
                carry = 1;
            }
            p.next = new ListNode(temp);
            p = p.next;
            p2 = p2.next;
        }

        if (carry != 0) {
            p.next = new ListNode(carry);
            carry = 0;
            p = p.next;
        }
        return dummyHead.next;
    }
}
